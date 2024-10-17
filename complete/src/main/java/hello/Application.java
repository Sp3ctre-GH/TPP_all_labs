package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String index() {
        return """
                <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Крутий калькулятор</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script>
        function calculate() {
            var expression = document.getElementById('expression').value;
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '/calculate?expression=' + encodeURIComponent(expression), true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById('result').innerHTML = xhr.responseText;
                }
            };
            xhr.send();
        }
    </script>
</head>
<body>
    <h1>Крутий калькулятор</h1>
    <input type="text" id="expression" placeholder="Уведіть приклад">
    <button onclick="calculate()">Розрахувати</button>
    <p id="result"></p>
</body>
</html>

                """;
    }

    @GetMapping("/calculate")
    @ResponseBody
    public String calculate(@RequestParam String expression) {
        try {
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();
            return "Результат: " + result;
        } catch (Exception e) {
            return "Не правильне значення, спробуйте ще раз";
        }
    }
}
