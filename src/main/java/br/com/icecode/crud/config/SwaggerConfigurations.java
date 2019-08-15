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
                .apis(RequestHandlerSelectors.basePackage("br.com.icecode.financeiro"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build());
//                .ignoredParameterTypes(Usuario.class)
//                .globalOperationParameters(Arrays.asList(
//                        new ParameterBuilder()
//                                .name("Authorization")
//                                .description("Header para token JWT")
//                                .modelRef(new ModelRef("string"))
//                                .parameterType("header")
//                                .required(false)
//                                .build()));
    }

    private ApiInfoBuilder informacoesApi() {

        return new ApiInfoBuilder()
                .title("Api-Financeiro")
                .description("Api para gestão financeira.")
                .version("1.0");
//                .termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.")
//                .license("Licença - Open Source")
//                .licenseUrl("http://www.ciceroednilson.com.br")
//                .contact(this.contato());

    }

//    private Contact contato() {
//
//        return new Contact(
//                "Cícero Ednilson",
//                "http://www.ciceroednilson.com.br",
//                "ciceroednilson@gmail.com");
//    }
}
