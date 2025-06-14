package com.tony.photoshader.shader;

import com.tony.photoshader.filter.BezierFilter;
import com.tony.photoshader.filter.BrightnessFilter;
import com.tony.photoshader.filter.ContrastFilter;
import com.tony.photoshader.filter.ExposureFilter;
import com.tony.photoshader.filter.Filter;
import com.tony.photoshader.filter.FlightFilter;
import com.tony.photoshader.filter.HueFilter;
import com.tony.photoshader.filter.SaturaFilter;
import com.tony.photoshader.filter.SharpenFilter;
import com.tony.photoshader.filter.SineFilter;
import com.tony.photoshader.filter.SplitFilter;
import com.tony.photoshader.filter.WipeMixFilter;

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
        System.out.println(shaderType);
        if (cacheProgram.containsKey(shaderType))return cacheProgram.get(shaderType);
        Filter filter = null;
        if (shaderType == ShaderType.BRIGHT){
            filter = new BrightnessFilter();
        }else if (shaderType == ShaderType.CONTRAST){
            filter = new ContrastFilter();
        }else if (shaderType == ShaderType.EXPOSURE){
            filter = new ExposureFilter();
        }else if (shaderType == ShaderType.HUE){
            filter = new HueFilter();
        }else if (shaderType == ShaderType.SATURA){
            filter = new SaturaFilter();
        }else if (shaderType == ShaderType.Sharpen){
            filter = new SharpenFilter();
        }else if (shaderType == ShaderType.SPLIT2X2){
            filter = new SplitFilter(2);
        }else if (shaderType == ShaderType.SPLIT4X4){
            filter = new SplitFilter(4);
        }else if (shaderType == ShaderType.FLIGHT){
            filter = new FlightFilter();
        }else if (shaderType == ShaderType.SINE){
            filter = new SineFilter();
        }else if (shaderType == ShaderType.BEZIER){
            filter = new BezierFilter();
        }else if (shaderType == ShaderType.WIPE){
            filter = new WipeMixFilter();
        }
        if (filter!=null) {
            cacheProgram.put(shaderType, filter);
            filter.createShderProgram();
        }
        return filter;
    }
}
