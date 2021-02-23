# 数据库文档 

### tb_table_grade  表

| 字段名称 | 字段含义 | 字段类型| 字段长度 | 备注   |
| ---- | ---- | ------- | ---- | ---- |
| gid  | gid | INT   |      |      |
| meeting  | meeting | VARCHAR   |      |      |
| report  | report | VARCHAR   |      |      |
| check  | check | VARCHAR   |      |      |
| studio_hea  | studio_hea | VARCHAR   |      |      |
| public_hea  | public_hea | VARCHAR   |      |      |
| propagate  | propagate | VARCHAR   |      |      |
| pro_safe  | pro_safe | VARCHAR   |      |      |
| equip_safe  | equip_safe | VARCHAR   |      |      |
| operating  | operating | VARCHAR   |      |      |
| culture  | culture | VARCHAR   |      |      |
| control  | control | VARCHAR   |      |      |
| profit  | profit | VARCHAR   |      |      |
| innovate  | innovate | VARCHAR   |      |      |
| ent_achi  | ent_achi | VARCHAR   |      |      |
| ent_opinion  | ent_opinion | VARCHAR   |      |      |
| mana  | mana | VARCHAR   |      |      |
| match  | match | VARCHAR   |      |      |
| total_score  | total_score | VARCHAR   |      |      |
| conclusion  | conclusion | VARCHAR   |      |      |
| judge  | judge | VARCHAR   |      |      |
| date  | date | DATE   |      |      |
| grade_date_id  | 评分分类的id | INT   |      |      |
| is_grade  | 0代表已评审，1代表未评审 | ENUM   |      |      |
| tid  | tid | INT   |      |      |




### 接口列表

#### 查询所有数据  

##### url 

> /tableGrade/findAll.do

##### http请求方式 

> GET

##### 请求参数

无

##### 返回格式

```
[{
	"gid": gid,
	"meeting": meeting,
	"report": report,
	"check": check,
	"studioHea": studio_hea,
	"publicHea": public_hea,
	"propagate": propagate,
	"proSafe": pro_safe,
	"equipSafe": equip_safe,
	"operating": operating,
	"culture": culture,
	"control": control,
	"profit": profit,
	"innovate": innovate,
	"entAchi": ent_achi,
	"entOpinion": ent_opinion,
	"mana": mana,
	"match": match,
	"totalScore": total_score,
	"conclusion": conclusion,
	"judge": judge,
	"date": date,
	"gradeDateId": 评分分类的id,
	"isGrade": 0代表已评审，1代表未评审,
	"tid": tid,

},
.......
]
```



#### 分页查询数据  

##### url

> /tableGrade/findPage.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明    |
| ---- | ---- | ---- | ----- |
| page | true | int  | 页码    |
| size | true | int  | 每页记录数 |

例子：

```
GET /tableGrade/findPage.do?page=1&size=10
```

##### 返回格式

```
{rows:[{
	"gid": gid,
	"meeting": meeting,
	"report": report,
	"check": check,
	"studioHea": studio_hea,
	"publicHea": public_hea,
	"propagate": propagate,
	"proSafe": pro_safe,
	"equipSafe": equip_safe,
	"operating": operating,
	"culture": culture,
	"control": control,
	"profit": profit,
	"innovate": innovate,
	"entAchi": ent_achi,
	"entOpinion": ent_opinion,
	"mana": mana,
	"match": match,
	"totalScore": total_score,
	"conclusion": conclusion,
	"judge": judge,
	"date": date,
	"gradeDateId": 评分分类的id,
	"isGrade": 0代表已评审，1代表未评审,
	"tid": tid,

},
.......
],
total:100}
```



#### 条件查询数据  

##### url

> /tableGrade/findList.do

##### http请求方式

> POST

##### 请求参数

| 参数        | 必选   | 类型   | 说明           |
| --------- | ---- | ---- | ------------ |
| searchMap | true | Map  | 条件对象，格式如实体对象 |

例子：

```
POST /tableGrade/findList.do
{
	"gid": gid,
	"meeting": meeting,
	"report": report,
	"check": check,
	"studioHea": studio_hea,
	"publicHea": public_hea,
	"propagate": propagate,
	"proSafe": pro_safe,
	"equipSafe": equip_safe,
	"operating": operating,
	"culture": culture,
	"control": control,
	"profit": profit,
	"innovate": innovate,
	"entAchi": ent_achi,
	"entOpinion": ent_opinion,
	"mana": mana,
	"match": match,
	"totalScore": total_score,
	"conclusion": conclusion,
	"judge": judge,
	"date": date,
	"gradeDateId": 评分分类的id,
	"isGrade": 0代表已评审，1代表未评审,
	"tid": tid,

}
```

##### 返回格式

```
[{
	"gid": gid,
	"meeting": meeting,
	"report": report,
	"check": check,
	"studioHea": studio_hea,
	"publicHea": public_hea,
	"propagate": propagate,
	"proSafe": pro_safe,
	"equipSafe": equip_safe,
	"operating": operating,
	"culture": culture,
	"control": control,
	"profit": profit,
	"innovate": innovate,
	"entAchi": ent_achi,
	"entOpinion": ent_opinion,
	"mana": mana,
	"match": match,
	"totalScore": total_score,
	"conclusion": conclusion,
	"judge": judge,
	"date": date,
	"gradeDateId": 评分分类的id,
	"isGrade": 0代表已评审，1代表未评审,
	"tid": tid,

},
.......
]
```



#### 条件+分页查询数据  

##### url

> /tableGrade/findPage.do

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
POST /tableGrade/findPage.do?page=1&size=10
{
	"gid": gid,
	"meeting": meeting,
	"report": report,
	"check": check,
	"studioHea": studio_hea,
	"publicHea": public_hea,
	"propagate": propagate,
	"proSafe": pro_safe,
	"equipSafe": equip_safe,
	"operating": operating,
	"culture": culture,
	"control": control,
	"profit": profit,
	"innovate": innovate,
	"entAchi": ent_achi,
	"entOpinion": ent_opinion,
	"mana": mana,
	"match": match,
	"totalScore": total_score,
	"conclusion": conclusion,
	"judge": judge,
	"date": date,
	"gradeDateId": 评分分类的id,
	"isGrade": 0代表已评审，1代表未评审,
	"tid": tid,

}
```

##### 返回格式

```
{rows:[{
	"gid": gid,
	"meeting": meeting,
	"report": report,
	"check": check,
	"studioHea": studio_hea,
	"publicHea": public_hea,
	"propagate": propagate,
	"proSafe": pro_safe,
	"equipSafe": equip_safe,
	"operating": operating,
	"culture": culture,
	"control": control,
	"profit": profit,
	"innovate": innovate,
	"entAchi": ent_achi,
	"entOpinion": ent_opinion,
	"mana": mana,
	"match": match,
	"totalScore": total_score,
	"conclusion": conclusion,
	"judge": judge,
	"date": date,
	"gradeDateId": 评分分类的id,
	"isGrade": 0代表已评审，1代表未评审,
	"tid": tid,

},
.......
],
total:100}
```



#### 根据ID查询数据  

##### url

> /tableGrade/findById.do

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

> /tableGrade/add.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tableGrade | true | tableGrade | 实体对象 |

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

> /tableGrade/update.do

##### http请求方式

> POST

##### 请求参数

| 参数       | 必选   | 类型       | 说明   |
| -------- | ---- | -------- | ---- |
| tableGrade | true | tableGrade | 实体对象 |

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

> /tableGrade/delete.do

##### http请求方式

> GET

##### 请求参数

| 参数   | 必选   | 类型   | 说明   |
| ---- | ---- | ---- | ---- |
| id   | true | int  | 主键   |

例子：

```
GET /tableGrade/delete.do?id=1
```

##### 返回格式：

```
{
  code:0,
  message:""
}
```

code为0表示成功，为1表示失败
