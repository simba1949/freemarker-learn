# Freemarker使用手册

[TOC]



> - `${...}`： FreeMarker将会输出真实的值来替换大括号内的表达式，这样的表达式被称为 **interpolation**(插值)。
> - **FTL 标签** (FreeMarker模板的语言标签)： FTL标签和HTML标签有一些相似之处，但是它们是FreeMarker的指令，是不会在输出中打印的。 这些标签的名字以 `#` 开头。(用户自定义的FTL标签则需要使用 `@` 来代替 `#`)
> - **注释：** 注释和HTML的注释也很相似， 但是它们使用 `<#--` 注释内容 `-->` 来标识。 不像HTML注释那样，FTL注释不会出现在输出中(不出现在访问者的页面中)， 因为 FreeMarker会跳过它们。
>
> 其他任何不是FTL标签，插值或注释的内容将被视为静态文本， 这些东西不会被FreeMarker所解析；会被按照原样输出出来。
>
> FTL标签也被称为 **指令**。 这些指令在HTML的标签 (比如： `<table>` 和 `</table>`) 和HTML元素 (比如： `table` 元素) 中的关系是相同的。

## 标量

>  标量是最基本，最简单的数值类型 

- 字符串：
- 数值：
- 布尔值：
- 日期：日期变量可以存储和日期/时间相关的数据。 日期，时间，日期-时间

## 容器

这些值存在的目的是为了包含其他变量；它们只是容器。 它们包含的变量通常视为 *subvariables* (子变量)。容器的类型有：

- 哈希表：每个子变量都可以通过一个唯一的名称来查找。 这个名称是不受限制的字符串。哈希表 *并不确定其中子变量的顺序*。 也就是说没有第一个子变量，第二个子变量这样的说法等；变量仅仅是通过名称来访问的。 (就像Java语言中的HashMap一样，是实现了Hash算法的Map，不记录内部元素的顺序， 仅仅通过名称来访问。
- 序列：每个子变量通过一个整数来标识。第一个子变量的标识符是0， 第二个是1，第三个是2，这样来类推，而且子变量是有顺序的。这些数次通常被称为 *indexes*(索引，译者注)。序列通常比较密集，也就是所有的索引， 包括最后一个子变量的，它们和子变量都是相关联的，但不是绝对必要的。 子变量的类型也并不需要完全一致。
- 集合：从模板设计者角度来看，集合是有限制的序列。不能获取集合的大小， 也不能通过索引取出集合中的子变量，但是它们仍然可以通过 `list` 指令来遍历。

## 检索变量

### 从哈希表中检索数据

```html
book.author.name， 
book["author"].name， 
book.author.["name"]，
book["author"]["name"]。
```

### 从序列中检索数据

```html
animals[0].name
```

### 特殊变量

特殊变量是由FreeMarker引擎本身定义的。 使用它们，可以按照如下语法形式来进行： `.*variable_name*`。.

## 基本指令

### if 指令

```html
<!--
	userrss??表示是否为空，!userss??表示是否不为空
	common.username == '杜甫'，判断 common.username 的属性是否等于 '杜甫'
-->
<#-- if 指令-->
<#if  !userss??>
userss 不为 null
<#elseif common.username == '杜甫' >
userss 为 null，且 common.username == '杜甫'
<#else>
userss 不为 null,且 common.username != '杜甫'
</#if>
```

### list 指令

```html
<!-- 
	userss as item：userss表示要遍历的对象，
				   item是每次迭代的值，使用 ${} 取值
	
-->
<#list list as item>
    ${item}
<#else>
    list 为空
</#list>
或者
<#list list>
    <#items as item>
        ${item}
        </#items>
    <#else>
        list 为空
</#list>
```

### sep 指令

> 当不得不显示介于每个迭代项(但不能在第一项之前或最后一项之后) 之间的一些内容时，可以使用 `sep`。

```html
<#list list as item>
    ${item}<#sep><br>-------<br></#sep>
<#else>
    list 为空
</#list>
```

### break 指令

```html
<!--
	break 将仅存在于为每个迭代项调用的指令体中，而且只能存在于这样的指令中。
-->
<#list list>
    <#items as item>
        <#if item.id == 3>
            <#break>
        </#if>
        ${item}
    </#items>
<#else>
    list 为空
</#list>
```

### include 指令

```html
<#include "/copyright_footer.html">
```

### 自定义指令（见下）

## 插值

字符串：${...}

数字：${...}

日期/时间：

```html
${date?date}, 
${date?time},
${date?datetime}
自定义：
${dateString?string("yyyy-MM-dd HH:mm:ss zzzz)}
```

布尔：

```
${booleanTrueType?c}
```

## 表达式

### 序列

指定一个文字的序列，使用逗号来分隔其中的每个子变量， 然后把整个列表放到方括号中。例如：

```
<#list ["1", 2, "3", true?c] as x>
    ${x}<br>
</#list>
```

将会输出：

```
1
2
3
true
```

### 序列操作

#### 连接

```html
<#list ["Joe", "Fred"] + ["Julia", "Kate"] as user>
	${user}
</#list>
```

#### 序列切分

```html
<#assign  seq = ["A", "B", "C", "D", "E"]>
<#list seq[1..3] as i>
    ${i}
</#list>
```

### 值域

值域也是序列，但它们由指定包含的数字范围所创建， 而不需指定序列中每一项。

值域表达式的通用形式是( `*start*` 和 `*end*` 可以是任意的结果为数字表达式)：

- `start..end`： 包含结尾的值域。比如 `1..4` 就是 `[1, 2, 3, 4]`， 而 `4..1` 就是 `[4, 3, 2, 1]`。
- `start..<end` 或 `start..!end`： 不包含结尾的值域。比如 `1..<4` 就是 `[1, 2, 3]`，`4..<1` 就是 `[4, 3, 2]`, 而 `1..<1` 表示 `[]`。
- `start..*length`： 限定长度的值域，比如 `10..*4` 就是 `[10, 11, 12, 13]`，`10..*-4` 就是 `[10, 9, 8, 7]`，而 `10..*0` 表示 `[]`。
- `start..`： 无右边界值域。这和限制长度的值域很像，只是长度是无限的。 比如 `1..` 就是 `[1, 2, 3, 4, 5, 6, ... ]`，直到无穷大。 

```html
<#list (1..5) as i>
    ${i}<br>
</#list>
-------------------------
<#list (1..*5) as i>
    ${i}<br>
</#list>
```

### 哈希表

在模板中指定一个哈希表，就可以遍历用逗号分隔开的"键/值"对， 把列表放到花括号内即可。键和值成对出现并以冒号分隔。比如： `{ "name": "green mouse", "price": 150 }`。 请注意名和值都是表达式，但是用来检索的名称就必须是字符串类型， 而值可以是任意类型。

```html
<#assign hash = {"libai":666, "dufu": "888"} + {"baijuyi": true?c}>
${hash.libai}<br>
${hash.dufu}<br>
${hash.baijuyi}<br>
```

### 哈希表操作

#### 连接

```html
<#assign ages = {"Joe":23, "Fred":25} + {"Joe":30, "Julia":18}>
- Joe is ${ages.Joe}
- Fred is ${ages.Fred}
- Julia is ${ages.Julia}
```

#### 运算

### 算数运算

```
${100 - x * x}
${x / 2}
${12 % 10}
```

### 比较运算

```html
测试两个值相等使用 = (或者采用Java和C语言中的 == ；二者是完全等同的。) 测试两个值不等使用 !=。比如， 假设 user 是 ''Big Joe''：

<#if user == "Big Joe">
  It is Big Joe
</#if>
<#if user != "Big Joe">
  It is not Big Joe
</#if>
```

### 逻辑操作

```html
常用的逻辑操作符：

逻辑 或： ||
逻辑 与： &&
逻辑 非： !
```

### 内建函数

```html
${testString?upper_case}
${testString?html}
${testString?upper_case?html}

${testSequence?size}
${testSequence?join(", ")}
```

### 方法调用

```html
${repeat("Foo", 3)}
```

### 处理不存在的值

```html
不存在值检测操作符
使用形式： unsafe_expr?? 或 (unsafe_expr)??
```

### 赋值操作符

这些并不是表达式，只是复制指令语法的一部分，比如 [`assign`](http://freemarker.foofun.cn/ref_directive_assign.html), [`local`](http://freemarker.foofun.cn/ref_directive_local.html) 和 [`global`](http://freemarker.foofun.cn/ref_directive_global.html)。 照这样，它们不能任意被使用。

`<#assign x += y>` 是 `<#assign x = x + y>` 的简写，`<#assign x *= y>` 是 `<#assign x = x * y>`的简写等等。。。

## 自定义指令

### 基本内容

宏是有一个变量名的模板片段。可以在模板中使用宏作为自定义指令， 这样就能进行重复性的工作。例如，创建一个宏变量来输出大字号的''Hello Joe!''：

```
<#macro greet>
  <font size="+2">Hello Joe!</font>
</#macro>
```

`macro` 指令自身不输出任何内容， 它只是用来创建宏变量，所以就会有一个名为 `greet` 的变量。在 `<#macro greet>` 和 `</#macro>` 之间的内容 (称为 **宏定义体**) 将会在使用该变量作为指令时执行。可以在FTL标记中通过 `@`代替`#`来使用自定义指令。 使用变量名作为指令名。而且，自定义指令的 [结束标记](http://freemarker.foofun.cn/gloss.html#gloss.endTag) 也是需要的。那么， 就可以这样来使用 `greet`：

```
<@greet></@greet>
```

### 参数

我们来改进 `greet` 宏使之可以使用任意的名字， 而不仅仅是''Joe''。为了实现这个目的，就要使用到 **参数**。在 `macro` 指令中，宏名称的后面位置是用来定义参数的。这里我们仅在 `greet`宏中定义一个参数，`person`：

```
<#macro greet person>
  <font size="+2">Hello ${person}!</font>
</#macro>
```

那么就可以这样来使用这个宏：

```
<@greet person="Fred"/> and <@greet person="Batman"/>
```

这和HTML的语法是很相似的，将会输出：

```
  <font size="+2">Hello Fred!</font>
 and   <font size="+2">Hello Batman!</font>
```

### 嵌套内容

自定义指令可以嵌套内容，和预定义指令相似：`<#if *...*>*nested content*</#if>`。 例如，下面这个例子中是创建了一个可以为嵌套的内容画出边框的宏：

```
<#macro border>
  <table border=4 cellspacing=0 cellpadding=4><tr><td>
    <#nested>
  </tr></td></table>
</#macro>
```

`<#nested>` 指令执行位于开始和结束标记指令之间的模板代码段。 如果这样写：

```
<@border>The bordered text</@border>
```

将会输出：

```
  <table border=4 cellspacing=0 cellpadding=4><tr><td>
    The bordered text
  </td></tr></table>
```

### 宏和循环变量

像 `list`这样的预定义指令可以使用循环变量； 可以阅读 [在模板中定义变量](http://freemarker.foofun.cn/dgui_misc_var.html) 来理解循环变量。

自定义指令也可以有循环变量。比如我们来扩展先前例子中的 `do_thrice` 指令，就可以拿到当前的循环变量的值。 而对于预定义指令(如`list`)，当调用指令时，循环变量的 *name*是给定的(比如 `<#list foos as foo>*...*</#list>` 中的 `foo`)，变量 *value* 的设置是由指令本身完成的。

```
<#macro do_thrice>
  <#nested 1>
  <#nested 2>
  <#nested 3>
</#macro>
<@do_thrice ; x> <#-- user-defined directive uses ";" instead of "as" -->
  ${x} Anything.
</@do_thrice>
```

将会输出：

```
  1 Anything.
  2 Anything.
  3 Anything.
```

### 在引入的命名空间中编写变量

偶尔想要在一个被包含的命名空间上创建或替换一个变量。 那么可以使用 `assign` 指令， 如果用到了它的 `namespace` 变量，例如下面这样：

```
<#import "/lib/my_test.ftl" as my>
${my.mail}
<#assign mail="jsmith@other.com" in my>
${my.mail}
```

将会输出：

```
jsmith@acme.com
jsmith@other.com
```

## 附录

\<a\> 标签

```html
<!-- / 表示 localhost:8080 -->
<a href="/user/href">点击进入金矿山中</a>
```



