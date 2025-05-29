package com.tony.photoshader.shader;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.tony.photoshader.filter.ChangeAFilter;
import com.tony.photoshader.filter.ChangeColorFilter;
import com.tony.photoshader.filter.ChangeScaleFilter;
import com.tony.photoshader.filter.Filter;
import com.tony.photoshader.filter.GrayFilter;

import java.util.HashMap;

public class ShaderUtils {
    private static ShaderUtils manager;
    private HashMap<ShaderType, Filter> cacheProgram;
    private ShaderUtils(){
        cacheProgram = new HashMap<>();
    }

    public void enterGameClear(){
        if (manager!=null){
            try {
                manager.cacheProgram.clear();
            }catch (Exception e){
//            System.out.println("dispose error");
            }
        }
        manager = null;
    }

    public static ShaderUtils getManager() {
        if (manager == null){
            manager = new ShaderUtils();
        }
        return manager;
    }

    public Filter getType(ShaderType shaderType){
        if (cacheProgram.containsKey(shaderType))return cacheProgram.get(shaderType);
        Filter filter = null;
        if (shaderType == ShaderType.A){
            filter = new ChangeAFilter();
        }else if (shaderType == ShaderType.COLOR){
            filter = new ChangeColorFilter();
        }else if (shaderType == ShaderType.SCALE){
            filter = new ChangeScaleFilter();
        }
        if (filter!=null) {
            cacheProgram.put(shaderType, filter);
            filter.createShderProgram();
        }
        return filter;
    }
}
