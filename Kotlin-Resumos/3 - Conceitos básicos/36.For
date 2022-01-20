36.For-loop

- Mesmo que seus objetivo seja o mesmo, é interessante notar que há uma diferença na assinatura do for
em Kotlin.

- Ao invés de utilizarmos o clássico 'for(int i = 0; i < limite; i++)', em Kotlin utilizaremos o já
apresentando 'range'.

Exemplo :: Crescente

	for(i in 1..10){
		println(i)
	}


	ou

	for(i in 0..100 step 5){
		println(i)
	}

Exemplo :: Decrescente

	for(i in 10 downTo 1){
		println(i)
	}

	ou 

	for(i in 100 downTo 0 step 5){
		println(i)
	}

Exemplo :: Utilizando um index externo

	val alunos = arrayListOf("Rafael", "Heitor", "Daniela")

	for ( (indice, alunos) in alunos.withIndex() ){
		println("${indice} - ${aluno}")
	}
