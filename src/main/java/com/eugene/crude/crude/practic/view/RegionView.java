package com.eugene.crude.crude.practic.view;



import com.eugene.crude.crude.practic.controller.ControllerImpl.RegionControllerImpl;
import com.eugene.crude.crude.practic.model.PostOrRegion;
import com.eugene.crude.crude.practic.model.PostOrRegionImpl;
import com.eugene.crude.crude.practic.model.Region;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RegionView implements  View {
    RegionControllerImpl regionController = new RegionControllerImpl();
    PostOrRegionImpl postOrRegion = new PostOrRegionImpl();
    public void viewDeleteById(String str) throws IOException {

        regionController.deleteById(str);
        System.out.println("Регино с id=" + str + " удален из файла");
    }

    public void viewSave(PostOrRegion region) throws IOException {

        region = regionController.save(region);
        if (region != null)
            System.out.println("Регино " + "'" + region.getContent() + "'" + " сохранен с id=" + region.getId());
        else System.out.println("Ошбика:Регион не может быть сохранен!");
    }

    public void viewGetAll() throws IOException {

        List<PostOrRegion> regionList = regionController.getAll();
        if (regionList.isEmpty())
            System.out.println("Файл пуст");
        else {
            System.out.println("Список регионов:");
            for (PostOrRegion region : regionList) {
                System.out.println(region.getId() + "," + region.getContent());
            }
        }
    }

    public void viewUpdate(PostOrRegion region) throws IOException {

        PostOrRegion region1 = regionController.Update(region);
        if (region1 != null)
            System.out.println("Идентификатор id=" + region.getId() + " теперь присвоен региону '" + region.getContent() + "'");
        else System.out.println("Ошибка:Регион не может быть изменен");
    }

    public void viewGetRegionById(String str) throws IOException {

        PostOrRegion region = regionController.getElementById(str);
        if (region != null)
            System.out.println("Идентификатор id=" + region.getId() + "принадлежит Региону '" + region.getContent());
        else System.out.println("Регион не найден!");
    }

    public String routing() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("РАБОТА С ФАЙЛОМ  'region.txt':\n\n");
        System.out.println("Доступный список действий:\n ");
        System.out.println("1. Введите команду -'LIST'   чтобы получить список регионов");
        System.out.println("2. Введите команду -'BYID'   чтобы получить регион по id ");
        System.out.println("3. Введите команду -'SAVE'   чтобы сохранить регион");
        System.out.println("4. Введите команду -'UPDATE' чтобы изменить регион");
        System.out.println("5. Введите команду -'DELETE' чтобы удалить  регион");
        System.out.println("6. Введите команду -'POST' для перехода к файлу 'post.json':");
        System.out.println("7. Введите команду -'USER' для перехода к файлу 'user.json':");
        String str = reader.readLine();
        switch (str) {
            case "LIST": {
                viewGetAll();
                break;
            }
            case "BYID": {
                System.out.println("Введите id7: ");
                String id = reader.readLine();
                viewGetRegionById(id);
                break;

            }
            case "SAVE": {
                System.out.println("Введите id3: ");
                String id = reader.readLine();
                System.out.println("Введите Регион: ");
                String regionName = reader.readLine();

                PostOrRegion region = postOrRegion.createPostOrRegion("region");
                region.setId(id);
                region.setContent(regionName);
                viewSave(region);
                break;
            }
            case "UPDATE": {
                System.out.println("Введите id2: ");
                String id = reader.readLine();
                System.out.println("Введите Регион: ");
                String regionName = reader.readLine();
                PostOrRegion region =  postOrRegion.createPostOrRegion("region");
                region.setId(id);
                region.setContent(regionName);
                viewUpdate(region);
                break;
            }
            case "DELETE": {
                System.out.println("Введите id1: ");
                String id = reader.readLine();
                viewDeleteById(id);
                break;
            }
            case "POST":{
                return "POST";
            }
            case "USER": {
                return "USER";
            }
        }
        System.out.println("Продолжить работу? Y/N :");
        str = reader.readLine();
       return str;
    }
}