package api.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.mail.Address;
import java.util.List;

/**
 * Created by lw on 14-6-26.
 * <p/>
 * spring-data-mongodb中的实体映射是通过
 * <p/>
 * MongoMappingConverter这个类实现的。它可以通过注释把
 * <p/>
 * java类转换为mongodb的文档。
 * 它有以下几种注释：
 *
 * @Id - 文档的唯一标识，在mongodb中为ObjectId，它是唯一的，通过时间戳+机器标识+进程ID+自增计数器（确保同一秒内产生的Id不会冲突）构成。
 * @Document - 把一个java类声明为mongodb的文档，可以通过collection参数指定这个类对应的文档。
 * @DBRef - 声明类似于关系数据库的关联关系。ps：暂不支持级联的保存功能，当你在本实例中修改了DERef对象里面的值时，单独保存本实例并不能保存DERef引用的对象，它要另外保存，如下面例子的Person和Account。
 * @Indexed - 声明该字段需要索引，建索引可以大大的提高查询效率。
 * @CompoundIndex - 复合索引的声明，建复合索引可以有效地提高多字段的查询效率。
 * @GeoSpatialIndexed - 声明该字段为地理信息的索引。
 * @Transient - 映射忽略的字段，该字段不会保存到mongodb。
 * @PersistenceConstructor - 声明构造函数，作用是把从数据库取出的数据实例化为对象。该构造函数传入的值为从DBObject中取出的数据。
 * <p/>
 * <p/>
 * <p/>
 * 下面是支持的查询类型，每三条数据分别对应：（方法后缀，方法例子，mongodb原生查询语句）
 * <p/>
 * GreaterThan(大于)
 * findByAgeGreaterThan(int age)
 * {"age" : {"$gt" : age}}
 * <p/>
 * LessThan（小于）
 * findByAgeLessThan(int age)
 * {"age" : {"$lt" : age}}
 * <p/>
 * Between（在...之间）
 * findByAgeBetween(int from, int to)
 * {"age" : {"$gt" : from, "$lt" : to}}
 * <p/>
 * IsNotNull, NotNull（是否非空）
 * findByFirstnameNotNull()
 * {"age" : {"$ne" : null}}
 * <p/>
 * IsNull, Null（是否为空）
 * findByFirstnameNull()
 * {"age" : null}
 * <p/>
 * Like（模糊查询）
 * findByFirstnameLike(String name)
 * {"age" : age} ( age as regex)
 * <p/>
 * (No keyword) findByFirstname(String name)
 * {"age" : name}
 * <p/>
 * Not（不包含）
 * findByFirstnameNot(String name)
 * {"age" : {"$ne" : name}}
 * <p/>
 * Near（查询地理位置相近的）
 * findByLocationNear(Point point)
 * {"location" : {"$near" : [x,y]}}
 * <p/>
 * Within（在地理位置范围内的）
 * findByLocationWithin(Circle circle)
 * {"location" : {"$within" : {"$center" : [ [x, y], distance]}}}
 * <p/>
 * Within（在地理位置范围内的）
 * findByLocationWithin(Box box)
 * {"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}
 * <p/>
 * 尽管以上查询功能已经很丰富，但如果还不能满足使用情况的话可以用一下方法---基于mongodb原本查询语句的查询方式。
 * 例：在原接口中加入
 * @Query("{ 'name':{'$regex':?2,'$options':'i'}, sales': {'$gte':?1,'$lte':?2}}")
 * public Page<Product> findByNameAndAgeRange(String name,double ageFrom,double ageTo,Pageable page);
 * 注释Query里面的就是mongodb原来的查询语法，我们可以定义传进来的查询参数，通过坐标定义方法的参数。
 * <p/>
 * 还可以在后面指定要返回的数据字段，如上面的例子修改如下，则只通过person表里面的name和age字段构建person对象。
 * @Query(value="{ 'name':{'$regex':?2,'$options':'i'}, sales':{'$gte':?1,'$lte':?2}}",fields="{ 'name' : 1, 'age' : 1}")
 * public Page<Product> findByNameAndAgeRange(String name,double ageFrom,double ageTo,Pageable page);
 */
public class Spring_Data {

}

//以下引用一个官方文档的例子
@Document(collection = "person")
@CompoundIndexes({
        @CompoundIndex(name = "age_idx", def = "{'lastName': 1, 'age': -1}")
})
class Person<T extends Address> {
    @Id
    private String id;
    @Indexed(unique = true)
    private Integer ssn;
    private String firstName;
    @Indexed
    private String lastName;
    private Integer age;
    @Transient
    private Integer accountTotal;
    @DBRef
    private List<Account> accounts;
    private T address;

    public Person(Integer ssn) {
        this.ssn = ssn;
    }

    @PersistenceConstructor
    public Person(Integer ssn, String firstName, String lastName, Integer age, T address) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }
}

//Account类
@Document
class Account {
    @Id
    private ObjectId id;
    private Float total;
}