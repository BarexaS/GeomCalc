package calc.services.calculations;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HypotenuseCalcServiceImpl implements CalcService {
    @Override
    public Double calculate(Map<String, String> map) {
        if (map.keySet().size() != 2) {
            System.out.println("Invalid number of parameters");
            return 0.0;
        } else {
            List<Double> args = prepareArgs(map);
            return Math.sqrt(Math.pow(args.get(0), 2) + Math.pow(args.get(1), 2));
        }
    }

    private List<Double> prepareArgs(Map<String, String> map) {
        List<Double> result = new ArrayList<>();
        Collection<String> list = map.values();
        Set<String> keys = map.keySet();
        list.removeAll(keys);
        for (String value : list) {
            result.add(Double.parseDouble(value));
        }
        return result;
    }
}
