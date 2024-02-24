package com.alibou.aws;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080/demo/v1/swagger-ui/index.html
@RestController
@RequestMapping("/getDemo")
public class DemoController {

    private int counter;
    @GetMapping
    @ApiResponses(
            @ApiResponse(
                    responseCode="200",
                    description="Successful Operation",
                    content={@Content(
                            schema=@Schema(implementation = String.class))}
            )
    )
    public ResponseEntity<String> demo() {
        counter++;
        String res = String.format("<h1>Response from demo controller: Response number: %d<h1/>", counter);
        return ResponseEntity.status(200).body(res);
    }
}
