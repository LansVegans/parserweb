package onliner;

import net.parser.persistence.HibernateUtil;
import org.hibernate.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.parser.persistence.HibernateUtil.shutdown;

/**
 * Created by LansVegans on 04.03.2017.
 */
public class Testshop {
    Session session = HibernateUtil.getSessionFactory().openSession();
    @Test
    public  void properties() throws IOException {
        Document doc1 = Jsoup.connect("https://www.knsneva.ru/noutbuki/lenovo/catalog.html").get();//добавленно 9 Apple и 9 Asus
        Elements divClass = doc1.getElementsByAttributeValue("class", "adjHeight3");
        Elements h3 = divClass.select("a[href]");
        List<String> listURL = new ArrayList<String>();
        int counter = 0;
        for (Element divOne : h3) {
            String url = divOne.attr("href");
            listURL.add(url);
            counter++;
            if (counter > 9)
                break;
        }
        for (int i = 0; i < listURL.size(); i++) {
            String newURl = "https://www.knsneva.ru" + listURL.get(i);
            Document doc = Jsoup.connect(newURl).get();

            Elements table = doc.getElementsByAttributeValue("class", "g_ex_table");
            Elements tbody = table.select("tbody");
            Elements span = doc.getElementsByAttributeValue("class", "priceNal");
            String price = span.text();
            String nameNotebook = doc.getElementsByAttributeValue("class", "p010").select("h1").text();
            Elements d = doc.getElementsByAttributeValue("class","text expandable").select("font");
            for(Element di : d)
                di.getElementsByTag("span").remove();
           String s = d.text();
//            Elements descr =  doc.getElementsByTag("font");
//            descr.get(0).child(0).remove();
//            String desription = descr.text();
            String imgsrc = doc.getElementById("AbigImage").getElementsByTag("img").attr("src");
            imgsrc = "https://www.knsneva.ru" + imgsrc;
            System.out.println("Maven + Hibernate + MySQL");
            List<String> thKeys = new ArrayList<String>();
            List<String> tdValues = new ArrayList<String>();
            for (int n = 0; n < tbody.size(); n++) {

                Elements thKey = tbody.get(n).select("th");
                Elements tdValue = tbody.get(n).select("td");
               // String nameTable = tbody.get(n).select("h3").text();
                for (Element td : tdValue) {
                    td.getElementsByTag("h3").remove();
                    tdValues.add(td.text());

                }
                for (Element th : thKey)
                    thKeys.add(th.text());
                for (int t = 0; t < tdValues.size(); t++) {
                    if (tdValues.get(t).equals(""))
                        tdValues.remove(t);
                }
//                if (nameTable.equals("Общая информация"))
//                    generalInfo(thKeys, tdValues);
            }
            generalInfo(thKeys,tdValues,nameNotebook,price,s, imgsrc);
        }
        shutdown();
    }


        private void generalInfo(List th, List td,String nm, String pr, String ds ,String smi) {
        session.beginTransaction();
            System.out.println(nm + " being recovering!");
        net.parser.entity.Notebook gi = new net.parser.entity.Notebook();
            gi.setNotebook_name(nm);
            gi.setPrice(pr);
            gi.setDesrp(ds);
            gi.setSmallImg(smi);
        for (int i = 0; i < th.size(); i++) {
            if (th.get(i).equals("Производитель"))
                gi.setManufacturer((String) td.get(i));
            if(th.get(i).equals("Модель"))
                gi.setModel((String) td.get(i));
            if (th.get(i).equals("PN"))
                gi.setPn((String) td.get(i));
            if (th.get(i).equals("Производитель CPU"))
                gi.setManufacturerCPU((String) td.get(i));

            if (th.get(i).equals("Модель CPU"))
                gi.setModelCPU((String) td.get(i));

            if (th.get(i).equals("Тактовая частота CPU"))
                gi.setFrequencyCPU((String) td.get(i));

            if (th.get(i).equals("Количество ядер процессора"))
                gi.setNumCores((String) td.get(i));

            if (th.get(i).equals("Максимальная частота процессора"))
                gi.setMaxFrequency((String) td.get(i));

            if (th.get(i).equals("L2 Кэш"))
                gi.setCacheL2((String) td.get(i));

            if (th.get(i).equals("L3 Кэш"))
                gi.setCacheL3((String) td.get(i));
            if (th.get(i).equals("Объём памяти"))
                gi.setMemory((String) td.get(i));

            if (th.get(i).equals("Тип памяти"))
                gi.setTypeMemory((String) td.get(i));

            if (th.get(i).equals("Частота шины"))
                gi.setFrequencyShiny((String) td.get(i));
            if (th.get(i).equals("Скорость вращения"))
                gi.setRotationSpped((String) td.get(i));

            if (th.get(i).equals("Объем диска SSD"))
                gi.setMemoryDisk((String) td.get(i));
            if (th.get(i).equals("Объем диска HDD"))
                gi.setMemoryHDD((String) td.get(i));

            if (th.get(i).equals("Интерфейс"))
                gi.setInterfaceOf((String) td.get(i));
            if (th.get(i).equals("Матрица"))
                gi.setMatrix((String) td.get(i));

            if (th.get(i).equals("Диагональ"))
                gi.setDiagonal((String) td.get(i));

            if (th.get(i).equals("Разрешение"))
                gi.setScreenResol((String) td.get(i));

            if (th.get(i).equals("Особенности экрана"))
                gi.setQualitiDispl((String) td.get(i));

            if (th.get(i).equals("Покрытие экрана"))
                gi.setCoatedScreen((String) td.get(i));

            if (th.get(i).equals("Веб камера"))
                gi.setWebCam((String) td.get(i));
            if (th.get(i).equals("Производитель видеоадаптера"))
                gi.setManufacturerVideo((String) td.get(i));

            if (th.get(i).equals("Графический чипсет"))
                gi.setGraphChip((String) td.get(i));

            if (th.get(i).equals("Объем видеопамяти"))
                gi.setMemoryVideo((String) td.get(i));

            if (th.get(i).equals("Внешняя"))
                gi.setExternal((String) td.get(i));
            if (th.get(i).equals("Производитель видеоадаптера"))
                gi.setManufacturerVideo((String) td.get(i));

            if (th.get(i).equals("Графический чипсет"))
                gi.setGraphChip((String) td.get(i));

            if (th.get(i).equals("Объем видеопамяти"))
                gi.setMemoryVideo((String) td.get(i));

            if (th.get(i).equals("Внешняя"))
                gi.setExternal((String) td.get(i));
            if (th.get(i).equals("Тип привода"))
                gi.setTypeDriver((String) td.get(i));
            if (th.get(i).equals("Встроенный/Опционально"))
                gi.setBuiltIn((String) td.get(i));
            if (th.get(i).equals("Стереодинамики"))
                gi.setStereeSpeeakers((String) td.get(i));

            if (th.get(i).equals("Микрофон"))
                gi.setMicro((String) td.get(i));
            if (th.get(i).equals("USB 3.0"))
                gi.setUsb3_0((String) td.get(i));

            if (th.get(i).equals("USB 3.1"))
                gi.setUsb3_1((String) td.get(i));

            if (th.get(i).equals("Thunderbolt"))
                gi.setThunderbolt((String) td.get(i));

            if (th.get(i).equals("Display Port"))
                gi.setDisplayPort((String) td.get(i));

            if (th.get(i).equals("Thunderbolt 3"))
                gi.setThunderbolt3((String) td.get(i));

            if (th.get(i).equals("Card Reader"))
                gi.setCardReader((String) td.get(i));

            if (th.get(i).equals("HDMI"))
                gi.setHdmi((String) td.get(i));
            if (th.get(i).equals("WiFi"))
                gi.setWifi((String) td.get(i));

            if (th.get(i).equals("Bluetooth"))
                gi.setBluetooth((String) td.get(i));
            if (th.get(i).equals("Тип аккумулятора"))
                gi.setTypeBattary((String) td.get(i));

            if (th.get(i).equals("Работа без подзарядки"))
                gi.setLifeBattary((String) td.get(i));
            if (th.get(i).equals("Операционная система"))
                gi.setOperetingSystem((String) td.get(i));
            if (th.get(i).equals("Размеры (ШxВxГ)"))
                gi.setSizeOf((String) td.get(i));

            if (th.get(i).equals("Вес (нетто)"))
                gi.setWeightOf((String) td.get(i));

            if (th.get(i).equals("Вес (брутто, кг)"))
                gi.setWeightB((String) td.get(i));
            if (th.get(i).equals("Цвет"))
                gi.setColorOf((String) td.get(i));
        }
        session.save(gi);
        session.getTransaction().commit();
            System.out.printf(nm + " is finish recovering!");

    }
}

