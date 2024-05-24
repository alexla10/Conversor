import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        System.out.println("*****************\n");
        int numero = 0;
        double valor = 0;
        String menu = """
                Sea bienveenido al conversor de monedas, Escriba la conversion que desea realizar
                
                
                1)Dolar =>> Peso Argentino
                2)Peso Argentino ==> Dolar
                3)Dolar ==> Real Brasileño
                4)Real Brasileño ==> Dolar
                5)Dolar ==> Peso Colombiano
                6)Peso Colombiano ==> Dolar
                7)Salir
                
                
                Elija una opcion valida:
                """;

        Scanner opcion = new Scanner(System.in);
        Scanner monto = new Scanner(System.in);
        while(numero != 7){
            System.out.println(menu);
            numero = opcion.nextInt();
            String codigo = "b50be206082f783b1b77bfd2";
            if(numero > 7 || numero < 1) continue;
            if(numero == 7) break;

            System.out.println("Ingrese el monto que quiere convertir");
            valor = monto.nextDouble();

            switch (numero){
                case 1:
                    try {
                        String url_str = "https://v6.exchangerate-api.com/v6/b50be206082f783b1b77bfd2/pair/USD/ARS/"+ valor;

                        URL url = new URL(url_str);
                        HttpURLConnection request = (HttpURLConnection) url.openConnection();
                        request.connect();

                        JsonParser jp = new JsonParser();
                        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                        JsonObject jsonobj = root.getAsJsonObject();

                        Double res = jsonobj.get("conversion_result").getAsDouble();
                        System.out.println("El monto de : " + valor + " dolares corresponden a " + res + " pesos argentinos\n" );
                    }catch (Exception e) {
                        System.out.println("La conversion no se pudo hacer");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        String url_str = "https://v6.exchangerate-api.com/v6/b50be206082f783b1b77bfd2/pair/ARS/USD/"+ valor;

                        URL url = new URL(url_str);
                        HttpURLConnection request = (HttpURLConnection) url.openConnection();
                        request.connect();

                        JsonParser jp = new JsonParser();
                        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                        JsonObject jsonobj = root.getAsJsonObject();

                        Double res = jsonobj.get("conversion_result").getAsDouble();
                        System.out.println("El monto de : " + valor + " pesos argentinos corresponden a " + res + " dolares\n" );
                    }catch (Exception e) {
                        System.out.println("La conversion no se pudo hacer");
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        String url_str = "https://v6.exchangerate-api.com/v6/b50be206082f783b1b77bfd2/pair/USD/BRL/"+ valor;

                        URL url = new URL(url_str);
                        HttpURLConnection request = (HttpURLConnection) url.openConnection();
                        request.connect();

                        JsonParser jp = new JsonParser();
                        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                        JsonObject jsonobj = root.getAsJsonObject();

                        Double res = jsonobj.get("conversion_result").getAsDouble();
                        System.out.println("El monto de : " + valor + " dolares corresponden a " + res + " reales brasileños\n" );
                    }catch (Exception e) {
                        System.out.println("La conversion no se pudo hacer");
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    try {
                        String url_str = "https://v6.exchangerate-api.com/v6/b50be206082f783b1b77bfd2/pair/BRL/USD/"+ valor;

                        URL url = new URL(url_str);
                        HttpURLConnection request = (HttpURLConnection) url.openConnection();
                        request.connect();

                        JsonParser jp = new JsonParser();
                        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                        JsonObject jsonobj = root.getAsJsonObject();

                        Double res = jsonobj.get("conversion_result").getAsDouble();
                        System.out.println("El monto de : " + valor + " reales brasileños corresponden a " + res + " dolareso\n" );
                    }catch (Exception e) {
                        System.out.println("La conversion no se pudo hacer");
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    try {
                        String url_str = "https://v6.exchangerate-api.com/v6/b50be206082f783b1b77bfd2/pair/USD/COP/"+ valor;

                        URL url = new URL(url_str);
                        HttpURLConnection request = (HttpURLConnection) url.openConnection();
                        request.connect();

                        JsonParser jp = new JsonParser();
                        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                        JsonObject jsonobj = root.getAsJsonObject();

                        Double res = jsonobj.get("conversion_result").getAsDouble();
                        System.out.println("El monto de : " + valor + " dolares corresponden a " + res + " pesos colombianoso\n" );
                    }catch (Exception e) {
                        System.out.println("La conversion no se pudo hacer");
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    try {
                        String url_str = "https://v6.exchangerate-api.com/v6/b50be206082f783b1b77bfd2/pair/COP/USD/"+ valor;

                        URL url = new URL(url_str);
                        HttpURLConnection request = (HttpURLConnection) url.openConnection();
                        request.connect();

                        JsonParser jp = new JsonParser();
                        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                        JsonObject jsonobj = root.getAsJsonObject();

                        Double res = jsonobj.get("conversion_result").getAsDouble();
                        System.out.println("El monto de : " + valor + " pesos colombianos corresponden a " + res + " dolares\n" );
                    }catch (Exception e) {
                        System.out.println("La conversion no se pudo hacer");
                        e.printStackTrace();
                    }
                    break;
            }
        }

        opcion.close();
        System.out.println("Saliendo, Gracias por utilizar este servicio");

    }
}
