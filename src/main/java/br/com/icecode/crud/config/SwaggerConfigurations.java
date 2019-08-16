package br.com.icecode.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfigurations {

    @Bean
    public Docket detalheApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.icecode.crud"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build());
    }

    private ApiInfoBuilder informacoesApi() {

        return new ApiInfoBuilder()
                .title("Api-CRUD")
                .description("Api CRUD.")
                .version("1.0");
    }
}
