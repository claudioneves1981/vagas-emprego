### Api- Vagas Demo ###

Essa api faz o Rankeamento de vagas de acordo com as seguintes caracteristicas

- Tipo -  remoto, hibrido, presencial 
- Contrato - pj, clt, freelance, temporario, estagio, trainee, outros
- Interesse - baixissimo, baixo, medio, alto, altissimo
- Situacao - oferta, desisti, aguardando, congelada, andamento, eliminado

Tecnologias Usadas

- Spring 3.3.1
- Gradle
- Java 17
- Postman
- JWT Token
- H2 





Para testar a api faça do Download do repositorio fonte, ou clone usando git

```
$ git clone https://github.com/claudioneves1981/vagas-emprego.git
```

acesse a pasta principal

depois execute

```
$ ./gradlew bootRun
``` 

a aplicação vai rodar na porta 8080

Abra o postman 

para cadastrar um usuario 

acesse 

```
POST /api/v1/auth/register
```

para logar

```
POST /api/v1/auth/login
```

para ambos vc pode usar o payload abaixo

```
{
    "username" : "usuario",
    "password" : "senha"
}
```

o mesmo irá retornar um jwt token que vai inserir no header de Authorization

```
{
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjZm5lZ3VhY3UiLCJyb2xlIjoiVVNFUiIsImlhdCI6MTc1MTgzMTU4NiwiZXhwIjoxNzUxOTE3OTg2fQ.IdEEzZcb92ryScOkWXiOzYtJaSVSsYjyyVUUVKAiFkU",
    "token" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjZm5lZ3VhY3UiLCJyb2xlIjoiVVNFUiIsImlhdCI6MTc1MTgzMTU4NiwiZXhwIjoxNzUxOTE3OTg2fQ.IdEEzZcb92ryScOkWXiOzYtJaSVSsYjyyVUUVKAiFkU"
}

```

### Usos ###

vc pode fazer a consulta do usuario logado pelo endpoint

```

GET api/v1/auth/me

```

consulta usuarios cadastrados

```

GET api/v1/users

```

para atualizar um usuario

```

PUT /api/v1/users/1


Request Body 


{
        "username" : "username"
        "password" : "password"
}


Response Body 200

{
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
}

```

Deletar um usuario

``` 

DELETE api/v1/users/1

```



Para cadastrar uma vaga

```

POST api/v1/vagas

Request Body
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
{
      "empresa" : "Atento",
      "vaga" : "Auxiliar",                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
      "situacao" : "OFERTA",
      "origem" : "Redes Sociais",
      "interesse" : "BAIXISSIMO",
      "salario" : 2000.00,
      "contrato" : "PJ",
      "tipo" : "PRESENCIAL",
      "beneficios" : "Carro da Empresa",
      "observacoes" : "Vaga fica longe"
}

```

nas opcoes de situação, tipo, contrato e interesse você pode seguir a tabela abaixo.

<table>
<thead>
    <th>Tipo</th>
    <th>Contrato</th>
    <th>Situacao</th>
    <th>Interesse</th>
</thead>
<tbody>
<tr>
    <td>REMOTO</td>
    <td>PJ</td>
    <td>OFERTA</td>
    <td>BAIXISSIMO</td>
</tr>
<tr>
    <td>HIBRIDO</td>
    <td>CLT</td>
    <td>DESISTI</td>
    <td>BAIXO</td>
</tr>
<tr>
    <td>PRESENCIAL</td>
    <td>FREELANCE</td>
    <td>AGUARDANDO</td>
    <td>MEDIO</td>
</tr>
<tr>
    <td></td>
    <td>TEMPORARIO</td>
    <td>CONGELADA</td>
    <td>ALTO</td>
</tr>
<tr>
    <td></td>
    <td>ESTÁGIO</td>
    <td>ANDAMENTO</td>
    <td>ALTISSIMO</td>
</tr>
<tr>
    <td></td>
    <td>TRAINEE</td>
    <td>ELIMINADO</td>
    <td></td>
</tr>
<tr>
    <td></td>
    <td>OUTROS</td>
    <td>INSCRITO</td>
    <td></td>
</tr>
</tbody>
</table>



você pode fazer a consulta das vagas por usuario você pode usar o endpoint

```
GET /api/v1/vagas/me

```

o retorno será algo parecido com isso

```
[
    {
        "id": 1,
        "empresa": "TESTE",
        "vaga": "OPERARIO",
        "situacao": "OFERTA",
        "origem": "EMAIL",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "CLT",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:54:25",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 2,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "OFERTA",
        "origem": "REDES SOCIAIS",
        "interesse": "BAIXO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "HIBRIDO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:55:59",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 3,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "DESISTI",
        "origem": "REDES SOCIAIS",
        "interesse": "ALTO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "PRESENCIAL",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:56:51",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    }
]
```


As outras consultas seguem a seguinte logica

- por Tipo
    ```
  GET /api/v1/vagas/me/tipo/{tipo}
  ```
  Opções {remoto, hibrido, presencial}

Ex. /api/v1/vagas/me/tipo/REMOTO

```
[
    {
        "id": 1,
        "empresa": "TESTE",
        "vaga": "OPERARIO",
        "situacao": "OFERTA",
        "origem": "EMAIL",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "CLT",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:54:25",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 2,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "OFERTA",
        "origem": "REDES SOCIAIS",
        "interesse": "BAIXO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:55:59",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 3,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "DESISTI",
        "origem": "REDES SOCIAIS",
        "interesse": "ALTO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:56:51",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    }
]
```

- por Interesse
    ```
  GET /api/v1/vagas/me/interesse/{interesse}
  ```
  Opções {baixissimo, baixo, medio, alto, altissimo}

Ex. /api/v1/vagas/me/interesse/BAIXISSIMO

```
[
    {
        "id": 1,
        "empresa": "tESTE",
        "vaga": "oPERARIO",
        "situacao": "OFERTA",
        "origem": "EMAIL",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "CLT",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:54:25",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 2,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "OFERTA",
        "origem": "REDES SOCIAIS",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:55:59",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 3,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "DESISTI",
        "origem": "REDES SOCIAIS",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:56:51",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    }
]
```

- por Situação
    ```
                                                                                                                                                                                                                                                                                                                                                                                                GET /api/v1/vagas/me/situacao/{situacao}
  ```
  Opções {oferta,desisti,aguardando,congelada,andamento,eliminado}

Ex. /api/v1/vagas/me/situacao/DESISTI

```
[
    {
        "id": 1,
        "empresa": "tESTE",
        "vaga": "oPERARIO",
        "situacao": "DESISTI",                                                                                  
        "origem": "EMAIL",                                                                                                        
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "CLT",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:54:25",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 2,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "DESISTI",
        "origem": "REDES SOCIAIS",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:55:59",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 3,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "DESISTI",
        "origem": "REDES SOCIAIS",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:56:51",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    }
]
```

- por Contrato
    ```
  GET /api/v1/vagas/me/contrato/{contrato}
  ```
  Opções {pj, clt, freelance, temporario, estagio, trainee, outros}

Ex. /api/v1/vagas/me/contrato/FREELANCE

```
[
    {
        "id": 1,
        "empresa": "tESTE",
        "vaga": "oPERARIO",
        "situacao": "DESISTI",
        "origem": "EMAIL",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "FREELANCE",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:54:25",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 2,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "DESISTI",
        "origem": "REDES SOCIAIS",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "FREELANCE",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:55:59",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    },
    {
        "id": 3,
        "empresa": "ATENTO",
        "vaga": "ATENDENTE",
        "situacao": "DESISTI",
        "origem": "REDES SOCIAIS",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "FREELANCE",
        "tipo": "REMOTO",
        "beneficios": "vr",
        "inscricao": "2025-07-06T16:56:51",
        "observacoes": "Vaga fica em outro estado",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    }
]
```

Atualizando uma Vaga.

```

PUT api/v1/vagas/1

Request Body

{
"empresa" : "Atento",
"vaga" : "Auxiliar",
"situacao" : "OFERTA",
"origem" : "Redes Sociais",
"interesse" : "BAIXISSIMO",
"salario" : 2000.00,
"contrato" : "PJ",
"tipo" : "PRESENCIAL",
"beneficios" : "Carro da Empresa",
"observacoes" : "Vaga fica longe"
}

Response Body 200

{
        "id": 3,
        "empresa": Atento",
        "vaga": "Auxiliar",
        "situacao": "OFERTA",
        "origem": "Redes Sociais",
        "interesse": "BAIXISSIMO",
        "salario": 2000.0,
        "contrato": "PJ",
        "tipo": "PRESENCIAL",
        "beneficios": "Carro da Empresa",
        "inscricao": "2025-07-06T16:56:51",
        "observacoes": "Vaga fica longe",
        "user": {
            "id": 1,
            "name": "cfneguacu",
            "role": "USER"
        }
    }
    
```
  
Deletando uma vaga

```
DELETE api/v1/vagas/1
```
