package tests.day20_xmlFiles;

public class C01_BugünXMLDosyalarolusturuldu {
    /*

*********************************************XML FİLE OLUŞTURMA***************************************************************
    Xml dosyasi framework’umuzdeki belirli testleri veya tum testleri otomatik olarak
    calistirmak icin kullandigimiz otomasyon dosyasidir.
    -
    *Olusturma

    *Calistirma=> Belirli package, class,method (lar) icin

    *include, exclude

    Testng framework ’de xml dosyasi kullanma nedenlerinden biri, belirli suitleri, testleri, packagelari, classları
    veya method lari çalıştırmaktır.

    Belirli testleri, package lari, classları veya method'lari dahil edebilir( include ) veya hariç (exclude ) tutabiliriz. Bu da
    bize esneklik (flexiblity kazandirir)

    Sadece birkaç basit yapılandırma ile TestNG.xml dosyasını kullanarak belirli test senaryolarını yürütebiliriz.

********************************************READ EXCEL TEKRAR****************************************************************
    *Read excel : Excel dosyalari web uygulamasinda degil bilgisayarimizda oldugu icin, driver ile
    degil Java'dan fileInputStream ile excel’e ulastik.

    =>İlk once dosya yolunu String bir degiskene atadik
    =>FIS ile dosya yolunu kullanip dosyaya eristik
    =>FIS’I parameter olarak kullanip workbook olusturduk
    =>workbook.(istenenMethod) ile sayfaya (sheet)
    =>sheet .(istenenMethod) ile istedigimiz satira (row)
    =>row .(istenenMethod) ile istenen hucreye ulastik (cell)

    *Cell objesi CELL class’indan gelir bir String olmadigi icin String manipulation method’lari
    uygulanamaz ama sout() icine yazilarak konsolda goruntulenebilir.

    *Eğer her seferinde bu kadar obje olusturmak istemezsek, workbook’a kladar ilerleyip sonra
    =>workbook. .(istenenSheetMethod). .(istenenRowMethod). .(istenenCellMethod) ile istenen cell’e ulasabiliriz

    *Satir sayilari ve cell numaralari index ile ulasilabilir.

    *Eger son satiri degil de reel olarak kullanilan satir sayisini istiyorsak=>  getPhysicalNumberOfRows() method’unu kullanabiliriz
     */
}
