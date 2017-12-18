package pl.decisiontree;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Jsons {

  public static final Gson GSON = new GsonBuilder()
      .registerTypeAdapter(Branch.class, new BranchDeserializer())
      .setPrettyPrinting()
      .create();
}
