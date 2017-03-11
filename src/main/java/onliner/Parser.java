package onliner;

import net.parser.entities.*;
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

public class Parser {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public static void main(String[] args) throws IOException {
//        Document doc = Jsoup.connect("https://www.knsneva.ru/noutbuki/apple/catalog.html").get();
//        Elements divClass = doc.getElementsByAttributeValue("class", "adjHeight3");
//        Elements h3 = divClass.select("a[href]");
//        List<String> listURL = new ArrayList<String>();
//        int counter = 0;
//        for (Element divOne : h3) {
//            String url = divOne.attr("href");
//            listURL.add(url);
//            counter++;
//            if (counter > 2)
//                break;
//        }
//
    }
//    @Test
//    public  void nameNotebook() throws IOException{
//        String newURl = "https://www.knsneva.ru/noutbuk-apple-macbook-pro-mf839ru-a/goods.html";
//        Document doc = Jsoup.connect(newURl).get();
//        String nameNotebook = doc.getElementsByAttributeValue("class","p010").select("h1").text();
//
//    }

    @Test
    public  void properties() throws IOException {
        Document doc1 = Jsoup.connect("https://www.knsneva.ru/noutbuki/asus/catalog.html").get();//добавленно 9 Apple и 9 Asus
        Elements divClass = doc1.getElementsByAttributeValue("class", "adjHeight3");
        Elements h3 = divClass.select("a[href]");
        List<String> listURL = new ArrayList<String>();
        int counter = 0;
        for (Element divOne : h3) {
            String url = divOne.attr("href");
            listURL.add(url);
            counter++;
            if (counter > 3)
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

            System.out.println("Maven + Hibernate + MySQL");

            session.beginTransaction();
            Notebook notebook = new Notebook();
            notebook.setNotebook_name(nameNotebook);
            notebook.setPrice(price);
            session.save(notebook);
            session.getTransaction().commit();

            for (int n = 0; n < tbody.size(); n++) {
                List<String> thKeys = new ArrayList<String>();
                List<String> tdValues = new ArrayList<String>();
                Elements thKey = tbody.get(n).select("th");
                Elements tdValue = tbody.get(n).select("td");
                String nameTable = tbody.get(n).select("h3").text();
//            System.out.println(nameTable);
//            System.out.println("--------------------------------");
//            System.out.println(thKey.text());
                for (Element td : tdValue) {
                    td.getElementsByTag("h3").remove();
                    tdValues.add(td.text());

                }
//            System.out.println(tdValue.text());
//            System.out.println();
//            System.out.println("--------------------------------");
                for (Element th : thKey)
                    thKeys.add(th.text());
                for (int t = 0; t < tdValues.size(); t++) {
                    if (tdValues.get(t).equals(""))
                        tdValues.remove(t);
                }

//            for (int t = 0; t < tdValues.size(); t++)
                //     System.out.println(tdValues.get(t));
                //  System.out.println();
                if (nameTable.equals("Общая информация"))
                    generalInfo(thKeys, tdValues, notebook);
                if (nameTable.equals("Центральный Процессор"))
                    cpu(thKeys, tdValues, notebook);
                if (nameTable.equals("Оперативная память"))
                    ram(thKeys, tdValues, notebook);
                if (nameTable.equals("Жесткий диск"))
                    hdd(thKeys, tdValues, notebook);
                if (nameTable.equals("Дисплей"))
                    display(thKeys, tdValues, notebook);
                if (nameTable.equals("Видеоадаптер"))
                    videoAdapter(thKeys, tdValues, notebook);
                if (nameTable.equals("Оптический привод"))
                    opticalDriver(thKeys, tdValues, notebook);
                if (nameTable.equals("Аудио/Звук"))
                    audioSound(thKeys, tdValues, notebook);
                if (nameTable.equals("Интерфейсы"))
                    interfacE(thKeys, tdValues, notebook);
                if (nameTable.equals("Коммуникации"))
                    communications(thKeys, tdValues, notebook);
                if (nameTable.equals("Аккумулятор"))
                    battery(thKeys, tdValues, notebook);
                if (nameTable.equals("Операционная система"))
                    operatingSystem(thKeys, tdValues, notebook);
                if (nameTable.equals("Физические параметры (брутто)"))
                    physParamB(thKeys, tdValues, notebook);
                if (nameTable.equals("Физические параметры (нетто)"))
                    physParamN(thKeys, tdValues, notebook);
                if (nameTable.equals("Дополнительные характеристики"))
                    additionalParam(thKeys, tdValues, notebook);

            }



        }
        shutdown();
    }


    public void generalInfo(List th, List td, Notebook nt) {
        session.beginTransaction();
        GeneralInfo gi = new GeneralInfo();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Производитель"))
                gi.setManufacturer((String) td.get(i));

            if (th.get(i).equals("PN"))
                gi.setPn((String) td.get(i));
        }
        gi.setNotebook(nt);
        session.save(gi);
        session.getTransaction().commit();

    }

    public void cpu(List th, List td, Notebook nt) {
        session.beginTransaction();
        CPU cp = new CPU();
        for (int i = 0; i < th.size(); i++) {
            if (th.get(i).equals("Производитель CPU"))
                cp.setManufacturerCPU((String) td.get(i));

            if (th.get(i).equals("Модель CPU"))
                cp.setModelCPU((String) td.get(i));

            if (th.get(i).equals("Тактовая частота CPU"))
                cp.setFrequencyCPU((String) td.get(i));

            if (th.get(i).equals("Количество ядер процессора"))
                cp.setNumCores((String) td.get(i));

            if (th.get(i).equals("Максимальная частота процессора"))
                cp.setMaxFrequency((String) td.get(i));

            if (th.get(i).equals("L2 Кэш"))
                cp.setCacheL2((String) td.get(i));

            if (th.get(i).equals("L3 Кэш"))
                cp.setCacheL3((String) td.get(i));

        }
        cp.setNotebook(nt);
        session.save(cp);
        session.getTransaction().commit();
    }

    public void ram(List th, List td, Notebook nt) {
        session.beginTransaction();
        RAM ra = new RAM();
        for (int i = 0; i < th.size(); i++) {
            if (th.get(i).equals("Объём памяти"))
                ra.setMemory((String) td.get(i));

            if (th.get(i).equals("Тип памяти"))
                ra.setTypeMemory((String) td.get(i));

            if (th.get(i).equals("Частота шины"))
                ra.setFrequencyShiny((String) td.get(i));
        }
        ra.setNotebook(nt);
        session.save(ra);
        session.getTransaction().commit();
    }

    public void hdd(List th, List td, Notebook nt) {
        session.beginTransaction();
        HDD hd = new HDD();
        for (int i = 0; i < th.size(); i++) {
            if (th.get(i).equals("Скорость вращения"))
                hd.setRotationSpped((String) td.get(i));

            if (th.get(i).equals("Объем диска SSD"))
                hd.setMemoryDisk((String) td.get(i));

            if (th.get(i).equals("Интерфейс"))
                hd.setInterfaceOf((String) td.get(i));
        }
        hd.setNotebook(nt);
        session.save(hd);
        session.getTransaction().commit();
    }

    public void display(List th, List td, Notebook nt) {
        session.beginTransaction();
        Display displ = new Display();
        for (int i = 0; i < th.size(); i++) {
            if (th.get(i).equals("Матрица"))
                displ.setMatrix((String) td.get(i));

            if (th.get(i).equals("Диагональ"))
                displ.setDiagonal((String) td.get(i));

            if (th.get(i).equals("Разрешение"))
                displ.setScreenResol((String) td.get(i));

            if (th.get(i).equals("Особенности экрана"))
                displ.setQualitiDispl((String) td.get(i));

            if (th.get(i).equals("Покрытие экрана"))
                displ.setCoatedScreen((String) td.get(i));

            if (th.get(i).equals("Веб камера"))
                displ.setWebCam((String) td.get(i));
        }
        displ.setNotebook(nt);
        session.save(displ);
        session.getTransaction().commit();
    }

    public void videoAdapter(List th, List td, Notebook nt) {
        session.beginTransaction();
        VideoAdapter vida = new VideoAdapter();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Производитель видеоадаптера"))
                vida.setManufacturerVideo((String) td.get(i));

            if (th.get(i).equals("Графический чипсет"))
                vida.setGraphChip((String) td.get(i));

            if (th.get(i).equals("Объем видеопамяти"))
                vida.setMemoryVideo((String) td.get(i));

            if (th.get(i).equals("Внешняя"))
                vida.setExternal((String) td.get(i));

        }
        vida.setNotebook(nt);
        session.save(vida);
        session.getTransaction().commit();
    }

    public void opticalDriver(List th, List td, Notebook nt) {
        session.beginTransaction();
        OpticalDriver optd = new OpticalDriver();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Тип привода"))
                optd.setTypeDriver((String) td.get(i));
            if (th.get(i).equals("Встроенный/Опционально"))
                optd.setBuiltIn((String) td.get(i));
        }
        optd.setNotebook(nt);
        session.save(optd);
        session.getTransaction().commit();
    }

    public void audioSound(List th, List td, Notebook nt) {
        session.beginTransaction();
        AudioSound aus = new AudioSound();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Стереодинамики"))
                aus.setStereeSpeeakers((String) td.get(i));

            if (th.get(i).equals("Микрофон"))
                aus.setMicro((String) td.get(i));
        }
        aus.setNotebook(nt);
        session.save(aus);
        session.getTransaction().commit();
    }

    public void interfacE(List th, List td, Notebook nt) {
        session.beginTransaction();
        Interfacess inter = new Interfacess();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("USB 3.0"))
                inter.setUsb3_0((String) td.get(i));

            if (th.get(i).equals("USB 3.1"))
                inter.setUsb3_1((String) td.get(i));

            if (th.get(i).equals("Thunderbolt"))
                inter.setThunderbolt((String) td.get(i));

            if (th.get(i).equals("Display Port"))
                inter.setDisplayPort((String) td.get(i));

            if (th.get(i).equals("Thunderbolt 3"))
                inter.setThunderbolt3((String) td.get(i));

            if (th.get(i).equals("Card Reader"))
                inter.setCardReader((String) td.get(i));

            if (th.get(i).equals("HDMI"))
                inter.setHdmi((String) td.get(i));
        }
        inter.setNotebook(nt);
        session.save(inter);
        session.getTransaction().commit();
    }

    public void communications(List th, List td, Notebook nt) {
        session.beginTransaction();
        Communications comm = new Communications();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("WiFi"))
                comm.setWifi((String) td.get(i));

            if (th.get(i).equals("Bluetooth"))
                comm.setBluetooth((String) td.get(i));
        }
        comm.setNotebook(nt);
        session.save(comm);
        session.getTransaction().commit();
    }

    public void battery(List th, List td, Notebook nt) {
        session.beginTransaction();
        Battary bat = new Battary();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Тип аккумулятора"))
                bat.setTypeBattary((String) td.get(i));

            if (th.get(i).equals("Работа без подзарядки"))
                bat.setLifeBattary((String) td.get(i));
        }
        bat.setNotebook(nt);
        session.save(bat);
        session.getTransaction().commit();
    }

    public void operatingSystem(List th, List td, Notebook nt) {
        session.beginTransaction();
        OperatingSystem opers = new OperatingSystem();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Операционная система"))
                opers.setOperetingSystem((String) td.get(i));
        }
        opers.setNotebook(nt);
        session.save(opers);
        session.getTransaction().commit();
    }

    public void physParamN(List th, List td, Notebook nt) {
        session.beginTransaction();
        PhysParamN physn = new PhysParamN();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Размеры (ШxВxГ)"))
                physn.setSizeOf((String) td.get(i));

            if (th.get(i).equals("Вес (нетто)"))
                physn.setWeightOf((String) td.get(i));
        }
        physn.setNotebook(nt);
        session.save(physn);
        session.getTransaction().commit();
    }

    public void physParamB(List th, List td, Notebook nt) {
        session.beginTransaction();
        PhysParamB physb = new PhysParamB();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Вес (брутто, кг)"))
                physb.setWeightB((String) td.get(i));

        }
        physb.setNotebook(nt);
        session.save(physb);
        session.getTransaction().commit();
    }

    public void additionalParam(List th, List td, Notebook nt) {
        session.beginTransaction();
        AdditionalChar addc = new AdditionalChar();
        for (int i = 0; i < th.size(); i++) {

            if (th.get(i).equals("Цвет"))
                addc.setColorOf((String) td.get(i));

        }
        addc.setNotebook(nt);
        session.save(addc);
        session.getTransaction().commit();
    }
}

