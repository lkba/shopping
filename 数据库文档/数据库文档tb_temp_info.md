# 数据库文档 

### tb_temp_info  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| tpid  | tpid | INT   |      |      |
| team  | team | VARCHAR   |      |      |
| project  | project | VARCHAR   |      |      |
| registered  | registered | ENUM   |      |      |
| money  | money | VARCHAR   |      |      |
| reg_time  | reg_time | DATE   |      |      |
| business_scope  | business_scope | VARCHAR   |      |      |
| class  | class | ENUM   |      |      |
| name  | name | VARCHAR   |      |      |
| age  | age | INT   |      |      |
| sex  | sex | ENUM   |      |      |
| department  | department | VARCHAR   |      |      |
| professional  | professional | VARCHAR   |      |      |
| phone  | phone | VARCHAR   |      |      |
| email  | email | VARCHAR   |      |      |
| fund  | fund | VARCHAR   |      |      |
| areawork  | areawork | ENUM   |      |      |
| persons  | persons | INT   |      |      |
| form  | form | VARCHAR   |      |      |
| thinking  | thinking | VARCHAR   |      |      |
| effect  | effect | VARCHAR   |      |      |
| abstract  | abstract | VARCHAR   |      |      |
| character  | character | VARCHAR   |      |      |
| feasibility  | feasibility | VARCHAR   |      |      |
| explain  | explain | VARCHAR   |      |      |
| prospectus  | prospectus | VARCHAR   |      |      |
| is_aud  | is_aud | ENUM   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /tempInfo/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"tpid": tpid,
	"team": team,
	"project": project,
	"registered": registered,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"name": name,
	"age": age,
	"sex": sex,
	"department": department,
	"professional": professional,
	"phone": phone,
	"email": email,
	"fund": fund,
	"areawork": areawork,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"isAud": is_aud,

},
.......
]
```



#### 分页查询数据  

##### url

> /tempInfo/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /tempInfo/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"tpid": tpid,
	"team": team,
	"project": project,
	"registered": registered,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"name": name,
	"age": age,
	"sex": sex,
	"department": department,
	"professional": professional,
	"phone": phone,
	"email": email,
	"fund": fund,
	"areawork": areawork,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"isAud": is_aud,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /tempInfo/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /tempInfo/findList.do
{
	"tpid": tpid,
	"team": team,
	"project": project,
	"registered": registered,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"name": name,
	"age": age,
	"sex": sex,
	"department": department,
	"professional": professional,
	"phone": phone,
	"email": email,
	"fund": fund,
	"areawork": areawork,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"isAud": is_aud,

}
```

##### 返回格式

```
[{
	"tpid": tpid,
	"team": team,
	"project": project,
	"registered": registered,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"name": name,
	"age": age,
	"sex": sex,
	"department": department,
	"professional": professional,
	"phone": phone,
	"email": email,
	"fund": fund,
	"areawork": areawork,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"isAud": is_aud,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /tempInfo/findPage.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |
| page      | true | int  | 页码（GET）      |
| size      | true | int  | 每页记录数（GET）   |

例子：

```
POST /tempInfo/findPage.do?page=1&size=10
{
	"tpid": tpid,
	"team": team,
	"project": project,
	"registered": registered,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"name": name,
	"age": age,
	"sex": sex,
	"department": department,
	"professional": professional,
	"phone": phone,
	"email": email,
	"fund": fund,
	"areawork": areawork,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"isAud": is_aud,

}
```

##### 返回格式

```
{rows:[{
	"tpid": tpid,
	"team": team,
	"project": project,
	"registered": registered,
	"money": money,
	"regTime": reg_time,
	"businessScope": business_scope,
	"class": class,
	"name": name,
	"age": age,
	"sex": sex,
	"department": department,
	"professional": professional,
	"phone": phone,
	"email": email,
	"fund": fund,
	"areawork": areawork,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"isAud": is_aud,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /tempInfo/findById.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键  |

例子：

```

```



#### 增加数据  

##### url

> /tempInfo/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tempInfo | true | tempInfo | 实体对象 |

##### 返回格式

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败



#### 修改数据  

##### url

> /tempInfo/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tempInfo | true | tempInfo | 实体对象 |

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败



#### 删除数据  

##### url

> /tempInfo/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /tempInfo/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
