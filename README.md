#  Java Spring REST API with JPA

### Proje Kurulumu

Projeyi öncelikle forklayın ve clone edin.
Daha sonra projeyi IntellijIDEA kullanarak açınız. README.md dosyasını dikkatli bir şekilde okuyarak istenenleri yapmaya çalışın.
Proje sayımız ilerledikçe proje yönetimimizi kolaylaştırmak adına projelerimizi belli klasör kalıplarında saklamak işimizi kolaylaştırmak adına iyi bir alışkanlıktır.
Örnek bir Lokasyon: Workintech/Sprint_1/Etud.

### Hedeflerimiz:

### Burger Rest Api

 ### Başlangıç
 * İçerisinde ```Spring Web, Spring Data Jpa, postgresql``` dependencyleri olduğundan emin olun.
 * Maven dependency management sistemini kullanarak tüm dependencyleri install edin.
 * Uygulamanızı  ```9000``` portundan ayağa kaldırın.
 * Bir casino için rest api dizayn etmeniz istenmektedir.

### Amaç
 * Amacımız veritabanına ekleme yapabileceğimiz bir casino API'yı hazırlamak.
 * Bu Api'yi oluştururken error handling ve validation kurallarına uymalıyız.
 * Dependency Injection kurallarına uymalıyız.
 
 ### Görev 1
 * main metodunuzun olduğu paket altında ```controller```, ```entity```, ```exceptions```, ```repository```, ```util``` isminde 5 adet daha paket oluşturunuz.
 * Project Lombok'u dependency olarak uygulamanıza ekleyin.
 * ```entity``` paketinin altına ```Card``` adında bir sınıf tanımlayınız. İçerisinde instance variable olarak ```id, value, type, color``` isminde 4 tane değişken oluşturun.
 * ```color``` değişkeni bir enum olmalı ve ```SPADE```, ```HEARTH```, ```DIAMOND```,```CLUB``` değerlerinden birini almalıdır.
 * ```type``` değişkeni de bir enum olmalı ve ```JACK```, ```QUEEN```, ```KING```,```ACE```, ```JOKER``` değerlerinden birini almalıdır.
 * Bir kartın hem ```type``` değeri hem de ```value``` değeri olamaz. value değeri varsa type değeri null olmalı. type varsa value değeri null olmalıdır.
 * Eğer kart tipi ```JOKER``` iser hem  ```value``` hem de ```color``` değerleri null olmalıdır.
 * JPA annotation larını uygulayarak bu sınıfı bir veritabanı tablosu olucak şekilde işaretleyiniz.
 * ```application.properties``` dosyanızı kullanarak veritabanı bağlantınızı kurun.
 * ```spring.jpa.hibernate.ddl-auto``` opsiyonu ile ilk başta tablonuzu create edin. Daha sonra bu opsiyonu değiştirerek tablolardaki verilerin silinmesini önleyin.
 * Spring uygulamasının veritabanı loglarını açarak veritabanına yolladığınız her soruguyu inceleyin.

### Görev 2
 * Dao paketi altında ```CardRepository``` isminde bir interface oluşturun.
 * içerisinde şu işlemleri yapıcak methodları tanımlamalısınız.
 * ```save``` => Card objesi alır ve bunu veritabanı tablosuna yazar.
 * ```findByColor``` => String color değeri alır ve karşılığında veritabanındaki color değeri verilen değere eşit olan kartları döner.
 * ```findAll``` => Hiçbir parametre almaz. Veritabanındaki bütün Cardları döner
 * ```findByValue``` => Integer value parametresi alır. Aldığı value değerindeki cardları döner
 * ```findByType``` => String type parametresi alır. type değerei verilen değerde olan tüm cardları döner.
 * ```update``` => Card objesi alır ve bunu var olan card objesi ile günceller.
 * ```remove``` => Bir adet id değeri alır ve bu id değerindeki Card'ı siler.
 * CardRepositoryImpl isimli bir sınıf yazınız. CardRepository sınıfını ```implements``` etmeli.

 ### Görev 3
 * ```controller``` paketi altında ```CardController``` adında 1 tane controller yazmalısınız.
 * CardRepositoryImpl sınıfını CardController sınıfı altında ```Dependency Injection``` yöntemini kullanarak çağırınız
 * Amacımız CRUD işlemlerini tanımlayan endpointler yazmak.
 * [GET]/workintech/cards => tüm card listini dönmeli.
 * [GET]/workintech/cards/byColor/{color} => Verilen renkteki kartları döner.
 * [POST]/workintech/cards => Bir adet card objesini veritabanına kaydeder.
 * [PUT]/workintech/cards/ => İlgili id deki card objesinin değerlerini yeni gelen data ile değiştirir.
 * [DELETE]/workintech/card/{id} => İlgili id değerindeki card objesini veritabanından siler.
 * [GET]/workintech/cards/byValue/{value} => Parametre olarak value değerini alır ve CardRepositoryImpl sınıfındaki findByType metodunu çağırır.
 * [GET]/workintech/cards/byType/{type} => Parametre olarak type değerini alır ve CardRepositoryImpl sınıfındaki findByType metodunu çağırır.

 ### Görev 3
 * Her endpointin hata fırlatabileceği senaryolar düşünülmeli ```exceptions``` paketi altına bu Error sınıfları oluşturulmalı.
 * Error Handling Global bir merkezden yönetilmeli. Controller sınıflarının altında olmamalı.
 * Her Controller ```@Slf4j``` ile işaretlenmelidir. Endpoint bir şekilde hata döndüğünde ```error logu``` basılmalı.
 * validation işlemleri controller sınıfı içinde kalmamalı. ```util``` paketi altında ```CardValidation``` isimli bir sınıf oluşturunuz. Validation işlemlerini buraya alınız.

### Görev 4
 * Codepen üzerinden veya bir React uygulaması oluşturarak Spring Boot ile yazdığımız projeye request atmayı deneyiniz.
  cors hatasını nasıl çözebiliriz.

 
