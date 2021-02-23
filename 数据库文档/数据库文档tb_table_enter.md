# 数据库文档 

### tb_table_enter  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| eid  | eid | INT   |      |      |
| money  | money | VARCHAR   |      |      |
| areawork  | areawork | ENUM   |      |      |
| enter_time  | 第几期入驻 | VARCHAR   |      |      |
| persons  | persons | INT   |      |      |
| form  | form | VARCHAR   |      |      |
| thinking  | thinking | TEXT   |      |      |
| effect  | effect | TEXT   |      |      |
| abstract  | abstract | TEXT   |      |      |
| character  | character | TEXT   |      |      |
| feasibility  | feasibility | TEXT   |      |      |
| explain  | explain | TEXT   |      |      |
| prospectus  | prospectus | TEXT   |      |      |
| data  | data | VARCHAR   |      |      |
| department_idea  | department_idea | TEXT   |      |      |
| date  | date | DATE   |      |      |
| tid  | tid | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /tableEnter/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"eid": eid,
	"money": money,
	"areawork": areawork,
	"enterTime": 第几期入驻,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"data": data,
	"departmentIdea": department_idea,
	"date": date,
	"tid": tid,

},
.......
]
```



#### 分页查询数据  

##### url

> /tableEnter/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /tableEnter/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"eid": eid,
	"money": money,
	"areawork": areawork,
	"enterTime": 第几期入驻,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"data": data,
	"departmentIdea": department_idea,
	"date": date,
	"tid": tid,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /tableEnter/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /tableEnter/findList.do
{
	"eid": eid,
	"money": money,
	"areawork": areawork,
	"enterTime": 第几期入驻,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"data": data,
	"departmentIdea": department_idea,
	"date": date,
	"tid": tid,

}
```

##### 返回格式

```
[{
	"eid": eid,
	"money": money,
	"areawork": areawork,
	"enterTime": 第几期入驻,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"data": data,
	"departmentIdea": department_idea,
	"date": date,
	"tid": tid,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /tableEnter/findPage.do

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
POST /tableEnter/findPage.do?page=1&size=10
{
	"eid": eid,
	"money": money,
	"areawork": areawork,
	"enterTime": 第几期入驻,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"data": data,
	"departmentIdea": department_idea,
	"date": date,
	"tid": tid,

}
```

##### 返回格式

```
{rows:[{
	"eid": eid,
	"money": money,
	"areawork": areawork,
	"enterTime": 第几期入驻,
	"persons": persons,
	"form": form,
	"thinking": thinking,
	"effect": effect,
	"abstract": abstract,
	"character": character,
	"feasibility": feasibility,
	"explain": explain,
	"prospectus": prospectus,
	"data": data,
	"departmentIdea": department_idea,
	"date": date,
	"tid": tid,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /tableEnter/findById.do

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

> /tableEnter/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tableEnter | true | tableEnter | 实体对象 |

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

> /tableEnter/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tableEnter | true | tableEnter | 实体对象 |

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

> /tableEnter/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /tableEnter/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
