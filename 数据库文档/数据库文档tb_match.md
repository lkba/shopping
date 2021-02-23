# 数据库文档 

### tb_match  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| id  | id | INT   |      |      |
| title  | title | VARCHAR   |      |      |
| host  | 举办方 | VARCHAR   |      |      |
| host_time  | host_time | VARCHAR   |      |      |
| host_place  | host_place | VARCHAR   |      |      |
| status  | 是否开始报名 | ENUM   |      |      |
| is_best  | 是否发布 | ENUM   |      |      |
| period  | 第几届比赛 | VARCHAR   |      |      |
| content  | content | TEXT   |      |      |
| date  | date | DATETIME   |      |      |
| release_time  | 发布时间 | DATE   |      |      |
| peoples  | 参加团队数量 | VARCHAR   |      |      |
| tid  | 团队id | INT   |      |      |
| cid  | 分类id | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /match/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"id": id,
	"title": title,
	"host": 举办方,
	"hostTime": host_time,
	"hostPlace": host_place,
	"status": 是否开始报名,
	"isBest": 是否发布,
	"period": 第几届比赛,
	"content": content,
	"date": date,
	"releaseTime": 发布时间,
	"peoples": 参加团队数量,
	"tid": 团队id,
	"cid": 分类id,

},
.......
]
```



#### 分页查询数据  

##### url

> /match/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /match/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"id": id,
	"title": title,
	"host": 举办方,
	"hostTime": host_time,
	"hostPlace": host_place,
	"status": 是否开始报名,
	"isBest": 是否发布,
	"period": 第几届比赛,
	"content": content,
	"date": date,
	"releaseTime": 发布时间,
	"peoples": 参加团队数量,
	"tid": 团队id,
	"cid": 分类id,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /match/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /match/findList.do
{
	"id": id,
	"title": title,
	"host": 举办方,
	"hostTime": host_time,
	"hostPlace": host_place,
	"status": 是否开始报名,
	"isBest": 是否发布,
	"period": 第几届比赛,
	"content": content,
	"date": date,
	"releaseTime": 发布时间,
	"peoples": 参加团队数量,
	"tid": 团队id,
	"cid": 分类id,

}
```

##### 返回格式

```
[{
	"id": id,
	"title": title,
	"host": 举办方,
	"hostTime": host_time,
	"hostPlace": host_place,
	"status": 是否开始报名,
	"isBest": 是否发布,
	"period": 第几届比赛,
	"content": content,
	"date": date,
	"releaseTime": 发布时间,
	"peoples": 参加团队数量,
	"tid": 团队id,
	"cid": 分类id,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /match/findPage.do

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
POST /match/findPage.do?page=1&size=10
{
	"id": id,
	"title": title,
	"host": 举办方,
	"hostTime": host_time,
	"hostPlace": host_place,
	"status": 是否开始报名,
	"isBest": 是否发布,
	"period": 第几届比赛,
	"content": content,
	"date": date,
	"releaseTime": 发布时间,
	"peoples": 参加团队数量,
	"tid": 团队id,
	"cid": 分类id,

}
```

##### 返回格式

```
{rows:[{
	"id": id,
	"title": title,
	"host": 举办方,
	"hostTime": host_time,
	"hostPlace": host_place,
	"status": 是否开始报名,
	"isBest": 是否发布,
	"period": 第几届比赛,
	"content": content,
	"date": date,
	"releaseTime": 发布时间,
	"peoples": 参加团队数量,
	"tid": 团队id,
	"cid": 分类id,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /match/findById.do

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

> /match/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| match | true | match | 实体对象 |

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

> /match/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| match | true | match | 实体对象 |

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

> /match/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /match/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
