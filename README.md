# Moplim - Movie2You

* Um desafio proposto por uma empresa, para processo seletivo com prazo de 5 dias.
* Moplim se trata de uma aplicação Android que lista categorias de filmes recentes, e permite a seleção para exibir detalhes do filme.
* A api de consulta utilizada é a [TheMovieDB](https://www.themoviedb.org/)

## Overview

<img src="/records/gif_app.gif" width="400">
<img src="/records/details_screen_1.jpeg" width="300">
<img src="/records/details_screen_2.jpeg" width="300">

### Tecnologias

* Android
* Kotlin
* buildSrc directory
* Clean Architecture
* Repository Pattern
* Observer Pattern
* Padrão MVVM
* ViewModel/LiveData
* DataBinding
* SplashScreen
* Fragments
* MaterialCardView
* Navigation
* Navigation safeArgs
* Glide
* BindingAdapter
* Kotlin Coroutines
* Consumo de API com Retrofit
* GSON converter
* RecyclerView
* Adapter

### Funcionamento

* Ao abrir o app o usuário apresenta uma SplashScreen com tempo de 3segundos
* Tela de listas de filmes contendo as categorias: Em Exibição - Em Breve - Mais Populares - Melhores Avaliados
* Na tela de listas e na tela de filmes semelhantes, a lista de filmes é atualizado dinamicamente conforme o usuário navega
* Ao clicar em um card, é acessado a tela de detalhes do filme, contendo alguns dados, reviews, e uma lista de filmes semelhantes

### Futuro

Alguns bugs serão corrigidos:

* O app possui alguns bugs como troca na orientação de tela, perde a funcionalidade de atualizar a lista dinamicamente
* Abrir o app sem acesso a internet causa erro na aplicação
