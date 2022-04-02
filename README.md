REST LOGIN API
----------------------------------------------------------------------------------------------

Login API built with Java 8, Spring Security, JWT and PostgreSQL.

When a user authenticates with valid credentials the API returns a JWT token.

----------------------------------------------------------------------------------------------

**The project was initially created with these dependencies:**


```

	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'org.postgresql:postgresql'
	annotationProcessor 'org.projectlombok:lombok'

```

----------------------------------------------------------------------------------------------

**Configuration in file application.properties:**

```

	server.port=8801
	
	spring.datasource.url=${DB_AUTH_URL}
	spring.datasource.username=${DB_AUTH_USERNAME}
	spring.datasource.password=${DB_AUTH_PASSWORD}
	
	spring.jpa.database-platform=postgres
	spring.jpa.hibernate.ddl-auto=none
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
	spring.jpa.show-sql=false
	
	logging.level.org.springframework.web=ERROR
	logging.level.com.example.demo=DEBUG


```

----------------------------------------------------------------------------------------------

**Configuration to allow access to the authentication endpoint:**

```

	import org.springframework.context.annotation.Configuration;
	import org.springframework.http.HttpMethod;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
	
	@Configuration
	@EnableWebSecurity
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {		
			http.csrf().disable()
	        		.authorizeRequests()
	        		.antMatchers(HttpMethod.POST, "/authenticate").permitAll()
	                .anyRequest().authenticated();
	    }	
		
	}

```

----------------------------------------------------------------------------------------------

