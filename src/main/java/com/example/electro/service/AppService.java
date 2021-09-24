package com.example.electro.service;

import com.example.electro.dataobjects.ApplianceDO;
import com.example.electro.dataobjects.UserApplianceDO;
import com.example.electro.entity.Appliance;
import com.example.electro.entity.User;
import com.example.electro.repository.UserRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppService {

    private UserRepository userRepository;

    public AppService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String hello() {
        return "Hello World";
    }

    @Cacheable(value = "userCache", key = "#userId")
    public UserApplianceDO findBy(Long userId) {
        System.out.println("Fetching From Database for name: " + userId);
        User user = this.userRepository.findById(userId).get();

        String connected = isConnected(user.getAppliances());

        List<ApplianceDO> applianceDOS = builtApplianceDO(user.getAppliances());

        return new UserApplianceDO(user.getId(), user.getName(), user.getAddress(), connected, applianceDOS);
    }

    private List<ApplianceDO> builtApplianceDO(List<Appliance> appliances) {
        ArrayList<ApplianceDO> applianceDOS = new ArrayList<>();
        ApplianceDO applianceDO = null;
        for (Appliance appliance: appliances) {
            applianceDO = new ApplianceDO(appliance.getAid(), appliance.getFactoryNumber(), appliance.getLastOnline().toString());
            applianceDOS.add(applianceDO);
        }
        return applianceDOS;
    }

    private String isConnected(List<Appliance> appliances) {
        for (Appliance appliance: appliances) {
            if (LocalDateTime.now().getMinute() - appliance.getLastOnline().toLocalDateTime().getMinute() > 1) {
                return "Not Connected";
            }
        }
        return "Connected";
    }
}
