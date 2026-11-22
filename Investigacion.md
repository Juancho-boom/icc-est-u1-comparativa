# INVESTIGACIÓN - Quick Sort

## Datos

 **Universidad Politécnica Salesiana**
- **Carrera:** Computación
- **Materia:** Estructura de Datos
- **Docente:** Ing. Pablo Torres
- **Autor:** Juan David Coronel Palacios
- **Práctica:** PL1.1

## 1. Implementación utilizada

Indica en qué archivo y métodos está Quick Sort, qué variante usaste (recursiva, in-place, tipo de partición, qué pivote) y de dónde tomaste la idea.

## 2. Funcionamiento

Explica con tus palabras el caso base, cómo trabaja la partición y cómo se llaman recursivamente los dos tramos.

## 3. Pivote y repetidos

Explica cómo se elige el pivote y qué pasa cuando hay valores iguales a él.

## 4. Traza de referencia

Haz la traza paso a paso de la entrada [7, 2, 7, 0, 4, 2] siguiendo tu código, con una tabla de tramo, pivote, intercambio y estado del arreglo.

| Tramo | Pivote | Intercambio | Estado después |
|---|---:|---|---|
|  |  |  |  |

## 5. Complejidad, memoria y estabilidad

Mejor caso, caso promedio y peor caso, con el motivo de cada uno. Luego explica el uso de memoria (incluida la pila de recursión) y si es estable o no, y por qué.

| Caso | Complejidad temporal | Motivo |
|---|---|---|
| Mejor caso | `O(n log n)` | El pivote divide el tramo en dos mitades parecidas. |
| Promedio | `O(n log n)` | Con datos aleatorios, las particiones quedan más o menos balanceadas. |
| Peor caso | `O(n²)` | El pivote es siempre el menor o el mayor, como en un arreglo ya ordenado. |

## 6. Caso desfavorable y observaciones

Describe qué entrada es el peor caso y por qué. Después compara con los resultados de Pruebas (n = 5 000, aleatorio contra ya ordenado) y con la tabla de abajo.

| Algoritmo | 10.000 (ms) | 50.000 (ms) | 100.000 (ms) |
|---|---:|---:|---:|
| Burbuja | 185.8069 | 6543.7858 |  |
| Quick Sort | 2.7551 | 9.1382 |  |
| Arrays.sort con int[] | 2.6242 | 10.3952 |  |
| Arrays.sort con Comparator en Integer[] | 23.1301 | 23.5399 |  |

Interpreta cómo crece cada algoritmo al aumentar el tamaño y menciona el efecto del calentamiento de la JVM (JIT) en la primera medición.

## 7. Fuentes y adaptación

Lista tus fuentes con la fecha en que las consultaste y explica qué adaptaste en tu código.