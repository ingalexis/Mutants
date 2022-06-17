# Mutants
Ejercicio mutantes dna

Para ejecutar el proyecto solo es necesario tener un jdk que acepte la version 8 
y ejecutar desde el archivo <br>src/main/java/com/prueba/mutants/MutantsApplication.java<br>
ya despues de iniciado el proyecto consumir el post al http://localhost:8080/mutants/ con el body json de ejemplo:

{
    "dna": [
        "TTGCAA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "ACCCTA",
        "TCACTG"
    ]
}

Solo hay dos respuestas

200 Ok es mutante 
403 Forbidden no es mutante
