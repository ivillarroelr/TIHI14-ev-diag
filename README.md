# TIHI14-ev-diag

TIHI14 es una API construida en Java con Spring Boot cuya finalidad es ser una prueba diagnóstica para el ramo de titulo "Taller de Integración de Software"

## Instalación

Usar el build tool [maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) para generar el jarfile. 

```bash
mvn clean install
```

## Endpoints

Para el endpoint POST se debe recibir un objeto tipo JSON en el request body con la siguiente estructura: 

```json
{
"title": "Operacion prueba 3 editada",
"price": 12000000,
"currency": "EUR",
"country": "BE",
"currency_id":1
}
```

Para el endpoint PUT se debe recibir un objeto tipo JSON en el request body con la siguiente estructura: 

```json
{
"title": "Operacion prueba 3 editada",
"price": 12000000,
"currency": "EUR",
"country": "BE"
}
```

```python
GET ${host}:8080/api/item/${itemId}
POST ${host}:8080/api/item/ 
DELETE ${host}:8080/api/item/${itemId}
PUT ${host}:8080/api/item/
```

## Información adicional

El servicio se encuentra actualmente desplegado en ambiente cloud, con proveedor GCP tanto para el API (Compute Engine) como para la base de datos (Cloud SQL PostgreSQL)

host: http://34.69.111.117:8080

## License
[MIT](https://choosealicense.com/licenses/mit/)
