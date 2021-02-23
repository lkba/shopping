# 数据库文档 

### tb_match_actor  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| ma_id  | ma_id | INT   |      |      |
| tid  | 队团id | INT   |      |      |
| tname  | 团队名称 | VARCHAR   |      |      |
| mid  | 事赛id | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /matchActor/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"maId": ma_id,
	"tid": 队团id,
	"tname": 团队名称,
	"mid": 事赛id,

},
.......
]
```



#### 分页查询数据  

##### url

> /matchActor/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /matchActor/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"maId": ma_id,
	"tid": 队团id,
	"tname": 团队名称,
	"mid": 事赛id,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /matchActor/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /matchActor/findList.do
{
	"maId": ma_id,
	"tid": 队团id,
	"tname": 团队名称,
	"mid": 事赛id,

}
```

##### 返回格式

```
[{
	"maId": ma_id,
	"tid": 队团id,
	"tname": 团队名称,
	"mid": 事赛id,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /matchActor/findPage.do

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
POST /matchActor/findPage.do?page=1&size=10
{
	"maId": ma_id,
	"tid": 队团id,
	"tname": 团队名称,
	"mid": 事赛id,

}
```

##### 返回格式

```
{rows:[{
	"maId": ma_id,
	"tid": 队团id,
	"tname": 团队名称,
	"mid": 事赛id,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /matchActor/findById.do

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

> /matchActor/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| matchActor | true | matchActor | 实体对象 |

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

> /matchActor/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| matchActor | true | matchActor | 实体对象 |

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

> /matchActor/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /matchActor/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
