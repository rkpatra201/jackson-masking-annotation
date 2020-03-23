package com.java.mask.manager;

import com.java.mask.generator.IMaskingGenerator;
import com.java.mask.generator.impl.MultiValueMaskingGenerator;
import com.java.mask.generator.impl.SingleValueMaskingGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaskingGeneratorManager {
    public static List<IMaskingGenerator> getGenerators() {
        return new ArrayList<IMaskingGenerator>(Arrays.asList(new SingleValueMaskingGenerator(), new MultiValueMaskingGenerator()));
    }
}
