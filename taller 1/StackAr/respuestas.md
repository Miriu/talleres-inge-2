# Taller #1 - Mutation Analysis

## Instrucciones
Completar este documento con las respuestas correspondientes a los ejercicios planteados en el enunciado del taller.

---

## Ejercicio 1: Resultados de generación de mutantes

1. ¿Cuántos mutantes se generaron en total?
   - Respuesta: Se generaron 75 mutantes.

2. ¿Qué operador de mutación generó más mutantes? ¿Cuántos y por qué?
   - Respuesta: Los operadores de mutación que generaron más mutantes son TrueConditionalsMutator y FalseConditionalsMutator, ambos con 10. Esto se debe a que el código de StackAr usa una gran cantidad de if statements.


3. ¿Qué operador de mutación generó menos mutantes? ¿Cuántos y por qué?
   - Respuesta: Los operadores de mutación que generan menos mutantes son EmptyReturnsMutator, IncrementsMutator,  NullReturnsMutator y ConditionalsBoundaryMutator. Para EmptyReturnsMutator y  NullReturnsMutator se debe a que los tipos de los returns son más raros en el código. Para ConditionalsBoundaryMutator, se debe a que solo se aplica sobre unos pocos operadores binarios. Para IncrementsMutator se debe a que el código no tiene muchos operadores unarios, solo 3.


---

## Ejercicio 2: Evaluación de test suites

1. ¿Cuántos mutantes vivos y muertos encontraron cada uno de los test suites?
   - **StackTests1**:
     - Mutantes vivos: 56
     - Mutantes muertos: 19
   - **StackTests2**:
     - Mutantes vivos: 38
     - Mutantes muertos: 37

2. ¿Cuál es el mutation score de cada test suite?
   - **StackTests1**: 25%
   - **StackTests2**: 49%

---

## Ejercicio 3: Mejora del test suite

1. ¿Cuál es el mutation score logrado para los tests de StackTests3?
   - Respuesta: 90%

2. ¿Cuántos mutantes vivos y muertos encontraron?
   - Mutantes vivos: 7
   - Mutantes muertos: 68

3. Comente cuáles son todos los mutantes vivos que quedaron y por qué son equivalentes al programa original (si no lo fueran, todavía es posible mejorar el mutation score).
   - Respuesta: Los mutantes vivos que quedaron fueron:
- StackArMutated8816 (FalseConditionalsMutator: Se reemplazó isEmpty() por false en la línea 45.)
- StackArMutated449 (FalseConditionalsMutator: Se reemplazó this == obj por false en la línea 72.)
- StackArMutated834 (MathMutator: Se reemplazó + por - en la línea 66.)
- StackArMutated999 (MathMutator: Se reemplazó + por - en la línea 65.)
- StackArMutated3350 (MathMutator: Se reemplazó * por / en la línea 65.)
- StackArMutated536 (ZeroConstantMutator: Se reemplazó 1 por 0 en la línea 64.)
- StackArMutated3009 (MinusOneConstantMutator: Se reemplazó 1 por -1 en la línea 64.)

StackArMutated8816 es equivalente al programa original porque cuando ese isEmpty es false el programa no va a tirar la excepción pero si que los hace inmediatamente después cuando se llama a this.top()

    if (false) {
    throw new IllegalStateException();
    }  
    Object rv = this.top();

En la implementación de top se usa el mismo bloque de código para chequear que el array de elems este vacío, por lo que este mutante es equivalente al programa original.

	if (isEmpty()) {
    throw new IllegalStateException();
    }



StackArMutated449 es equivalente porque las demás condiciones aseguran que si los elementos del array y el readIndex son iguales entre los dos stacks, entonces los stakcs son iguales, y claramente un stack cumple estas dos caracteristicas al compararse con sí mismo.

Los demás 5 mutantes que quedan son otras maneras válidas de calcular un hash, por lo que aunque no de el mismo hash que el programa original 2 hash de distintos stacks no van a colisionar en estos mutantes, con lo cual son equivalentes al programa original.


4. ¿Cuál es el instruction coverage promedio que lograron para las clases mutadas?
   - Respuesta: 55%

5. ¿Cuál es el peor instruction coverage que lograron para una clase mutada? ¿Por qué creen que sucede esto?
   - Respuesta: La clase StackArMutated5925 es la que tiene peor covarage con 4%. Esto se debe a que este mutante reemplaza a capacity < 0 por true, y el código para crear un Stack queda como


   ` if (true) {
        	throw new java.lang.IllegalArgumentException();
    	}
`
   - donde se puede ver que para cualquier stack que se quiera crear no se va a poder porque el programa siempre tirara una excepción.  