package br.com.icecode.crud.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;


@Getter
public class RecursoCriadoEvent extends ApplicationEvent implements Serializable {

    private HttpServletResponse response;

    private Long id;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long id) {
        super(source);
        this.response = response;
        this.id = id;
    }

}
