# ControleProdutos
Sistema de solicitação de produtos com autenticação ao logar.


# Trabalho de Programação Web - Controle Produtos

Pré-requisitos:
* Tela de Login: Campos: Login e senha
Ações: Logar, Limpar, Cadastrar novo usuário
Mensagem: Caso de login ou senha inválido informar a mensagem

* Cadastro de usuário, Campos: 
Login, Senha, Confirmar senha, Nome, Data de nascimento, Idade (somente leitura), Sexo, CEP, Logradouro, Número, Complemento, Cidade, UF. Campos Obrigatórios (Login, senha, confirmar senha, Data de nascimento, Sexo, CEP)

Regras:
* Campos com deverão ser sinalizados como *
* Senhas devem ser iguais nos campos senha e confirmar senha
* Conforme a data de nascimento VÁLIDA deve-se calcular a idade
* Realizar consultar no serviço de cep ou banco de dados e carregar os campos

Mensagens:
* Exibir mensagens quando os campos de campos senha e confirmar senha forem diferentes
* Data de nascimentos validas devem compreender 5 a 120 anos de vida de uma pessoa

Ação esperada:
Criar um usuário para realização do login
Após a criação, deverá voltar para a tela de loginSistema:
Após logar, deverá ser apresentado a listagem de produtos

Menu composto por:
<li>Produtos:
<li> * Listagem de produtos
<li> * Relatório
<li> * Relatório de movimentos
<li> * Sair
<li> * Sair do sistema e volta para o login

Listagem de produtos, Campos:
<li> 1. Produtos
<li>  • Nome do produto
<li> 2. Imagem do produto
<li>  • Exibir a imagem do produto
<li> 3. Medida
<li>  • Medida de quantidade do produto: resma de 100 papel A4, caixa com 20 canetas, etc
<li> 4. Preço
<li>  • Valor de cada produto (valor da medida)
<li> 5. Quantidade disponível
<li>  • Quantidade em estoque
<li> 6. Solicitar
Ação de solicitar o produto
Ações: Salvar solicitação, cancelar solicitação

Regras
* Considerar os produtos já cadastrados (não precisa construir o cadastro do produto)
* No solicitar deverá baixar a quantidade de estoque (não permitir estoque negativo) o Livre para criar uma tela, ou uma ação com botão, ou alguma outra solução.
* Mensagem: Quando tentar solicitar o estoque, e não for possível, deverá emitir uma mensagem

Relatório Campos:
* Usuário
* Data da solicitação
* Produto
* Quantidade
* Valor total

Ações:
* Exibir todos os lançamentos realizados
* Todos as solicitações realizadas por cada usuário com seus respectivos produtos por
* data
* Deverá calcular o total acumulado de tudo já solicitado
* Opcionalmente poderá incluir um filtro no relatório

Item obrigatório:
* Backend em JAVA

Critérios:
* Layout (harmonização de cores, disposição de campos em tela)
* Utilizar JQuery para validação de cálculos de frontend
* Utilizar MVC para construção do backend
* Utilizar um framework para conexão no banco de dados
* Utilizar Maven para gerenciamento de dependências
