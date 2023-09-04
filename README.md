### Api- Vagas Demo ###

Essa api faz o cadastro de vagas que um determinado usuario pode ter interesse ou n�o
de acordo com caracteristicas como 

- Tipo
- Contrato
- Interesse
- Situacao 

Para testar a api fa�a do Download do repositorio fonte, ou clone usando git

```
$ git clone https://github.com/claudioneves1981/vagas-emprego.git
```

acesse a pasta principal

depois execute

```
$ ./gradlew bootRun
``` 

a aplica��o vai rodar na porta 8080

Abra o postman 

para cadastrar um usuario 

acesse 

```
http://localhost:8080/users
```
![img.png](img.png)

nas opcoes de situa��o tipo, contrato e interesse � utilizado 
enumera��o

para o caso vc deseja cadastrar uma op��o especifica vc usara um numero correspondente.

<table>
<thead>
    <th>Opcao</th>
    <th>Tipo</th>
    <th>Contrato</th>
    <th>Situacao</th>
    <th>Interesse</th>
</thead>
<tbody>
<tr>
    <td>0</td>
    <td>REMOTO</td>
    <td>PJ</td>
    <td>OFERTA</td>
    <td>BAIXISSIMO</td>
</tr>
<tr>
    <td>1</td>
    <td>HIBRIDO</td>
    <td>CLT</td>
    <td>DESISTI</td>
    <td>BAIXO</td>
</tr>
<tr>
    <td>2</td>
    <td>PRESENCIAL</td>
    <td>FREELANCE</td>
    <td>AGUARDANDO</td>
    <td>MEDIO</td>
</tr>
<tr>
    <td>3</td>
    <td></td>
    <td>TEMPORARIO</td>
    <td>CONGELADA</td>
    <td>ALTO</td>
</tr>
<tr>
    <td>4</td>
    <td></td>
    <td>EST�GIO</td>
    <td>ANDAMENTO</td>
    <td>ALTISSIMO</td>
</tr>
<tr>
    <td>5</td>
    <td></td>
    <td>TRAINEE</td>
    <td>ELIMINADO</td>
    <td></td>
</tr>
<tr>
    <td>6</td>
    <td></td>
    <td>OUTROS</td>
    <td>INSCRITO</td>
    <td></td>
</tr>
</tbody>
</table>

para o login voc� usar� o seguinte end point

```
http://localhost:8080/login
```


![img_2.png](img_2.png)

o mesmo ir� retornar um jwt token que voc� usar� para fazer o acesso e as consultas

### Consultas ###

vc pode fazer a consulta das vagas por usuario usando o endpoint

```
http://localhost:8080/users/{usuario}/vagas/
```
![img_3.png](img_3.png)

So lembrando que deve se colocar o token JWT em Authorization

#### Outras consultas ####

As outras consultas seguem a seguinte logica

- por Tipo
    ```
  http://localhost:8080/users/{usuario}/vagas/tipo/{opc�es}
  ```
  Op��es {remoto, hibrido,presencial}



- por Interesse
    ```
  http://localhost:8080/users/{usuario}/vagas/interesse/{opcoes}
  ```
  Op��es {baixissimo, baixo, medio, alto, altissimo}


- por Situacao
  ```
  http://localhost:8080/users/{usuario}/vagas/situacao/{opc�es}
  ```
  Op��es {oferta,desisti,aguardando,congelada,andamento,eliminado,inscrito}


- por Contrato
    ```
  http://localhost:8080/users/{usuario}/vagas/contrato/{opc�es}
  ```
  Op��es {pj, clt, freelance, temporario, estagio, trainee, outros}


### Outras Op��es ###

Atualizando Cadastro

� feito por esse endpoint

```
http://localhost:8080/users/{id}
```
![img_4.png](img_4.png)
  
