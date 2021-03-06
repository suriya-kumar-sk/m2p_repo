//DatabaseConfig 

@Configuration
public class DatabaseConfig {
   @Bean(name = "dbM2p")   
   @Primary
   public DataSource createDataSource() {
      return DataSourceBuilder.create().build();
   }

   @Bean(name = "jdbcM2p")
   @Autowired
   public JdbcTemplate createJdbcTemplate(@Qualifier("dbProductService") DataSource DS) {
      return new JdbcTemplate(productServiceDS);
   }   
}
