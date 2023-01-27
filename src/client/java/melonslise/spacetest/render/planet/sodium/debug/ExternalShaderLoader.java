package melonslise.spacetest.render.planet.sodium.debug;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import me.jellysquid.mods.sodium.client.gl.shader.*;
import net.minecraft.client.gl.ShaderStage;
import net.minecraft.util.Identifier;
import org.apache.commons.io.IOUtils;
import qouteall.imm_ptl.core.render.ShaderCodeTransformation;

public class ExternalShaderLoader {
	public static GlShader loadShader(ShaderType type, Identifier name, ShaderConstants constants) {
		String shaderSource = getShaderSource(name);// 29
		shaderSource = ShaderCodeTransformation.transform(type == ShaderType.VERTEX ? ShaderStage.Type.VERTEX : ShaderStage.Type.FRAGMENT, name.toString(), shaderSource);// 30 31 32
		return new GlShader(type, name, ShaderParser.parseShader(shaderSource, constants));// 34
	}
	
	public static String getShaderSource(Identifier name) {
		String path = String.format("/assets/%s/shaders/%s", name.getNamespace(), name.getPath());// 26
		
		try {
			File fl = new File(path.substring(1));
			InputStream in;
			if (fl.exists()) {
				in = new FileInputStream(fl);
			} else {
				in = me.jellysquid.mods.sodium.client.gl.shader.ShaderLoader.class.getResourceAsStream(path);
			}
			
			String var3;
			try {
				if (in == null) {// 29
					throw new RuntimeException("Shader not found: " + path);// 30
				}
				
				var3 = IOUtils.toString(in, StandardCharsets.UTF_8);
			} catch (Throwable var6) {// 28
				if (in != null) {
					try {
						in.close();
					} catch (Throwable var5) {
						var6.addSuppressed(var5);
					}
				}
				
				throw var6;
			}
			
			if (in != null) {
				in.close();
			}
			
			return var3;// 33
		} catch (IOException var7) {// 34
			throw new RuntimeException("Failed to read shader source for " + path, var7);// 35
		}
	}
}

