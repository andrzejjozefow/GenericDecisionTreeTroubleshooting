package pl.decisiontree;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class BranchDeserializer implements JsonDeserializer<Branch> , JsonSerializer<Branch> {

  @Override
  public Branch deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

    JsonObject jsonObject = jsonElement.getAsJsonObject();

    return isLeaf(jsonObject)
        ? jsonDeserializationContext.deserialize(jsonObject, Leaf.class)
        : jsonDeserializationContext.deserialize(jsonObject, YesNoBranch.class);

  }

  private boolean isLeaf(JsonObject jsonObject){
    return jsonObject.get("answer") != null;
  }

  @Override
  public JsonElement serialize(Branch branch, Type type, JsonSerializationContext jsonSerializationContext) {
    return jsonSerializationContext.serialize(branch);
  }
}
