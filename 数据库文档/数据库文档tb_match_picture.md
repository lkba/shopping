# 数据库文档 

### tb_match_picture  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| pid  | pid | INT   |      |      |
| thumb  | 路径id | VARCHAR   |      |      |
| describe  | 照片描述 | VARCHAR   |      |      |
| mid  | 赛事的id | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /matchPicture/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"pid": pid,
	"thumb": 路径id,
	"describe": 照片描述,
	"mid": 赛事的id,

},
.......
]
```



#### 分页查询数据  

##### url

> /matchPicture/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /matchPicture/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"pid": pid,
	"thumb": 路径id,
	"describe": 照片描述,
	"mid": 赛事的id,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /matchPicture/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /matchPicture/findList.do
{
	"pid": pid,
	"thumb": 路径id,
	"describe": 照片描述,
	"mid": 赛事的id,

}
```

##### 返回格式

```
[{
	"pid": pid,
	"thumb": 路径id,
	"describe": 照片描述,
	"mid": 赛事的id,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /matchPicture/findPage.do

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
POST /matchPicture/findPage.do?page=1&size=10
{
	"pid": pid,
	"thumb": 路径id,
	"describe": 照片描述,
	"mid": 赛事的id,

}
```

##### 返回格式

```
{rows:[{
	"pid": pid,
	"thumb": 路径id,
	"describe": 照片描述,
	"mid": 赛事的id,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /matchPicture/findById.do

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

> /matchPicture/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| matchPicture | true | matchPicture | 实体对象 |

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

> /matchPicture/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| matchPicture | true | matchPicture | 实体对象 |

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

> /matchPicture/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /matchPicture/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
