package br.com.projetospring.configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.projetospring.entity.User;
import br.com.projetospring.repository.UserRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private UserRepository userRepository;

    @Value("classpath:data/lista_alunos.txt")
    private Resource resourceFile;

    @Bean
    public void insertUsers() {
        List<User> users = new ArrayList<User>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.resourceFile.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("---------------------------") || line.length() < 6) {
                    continue;
                }
                // você deve ajustar o restante doss atributos, ra, code, etc
                String name = line.substring(0, 41).trim();
                String code = line.substring(41, 55).trim();
                Integer ra = ThreadLocalRandom.current().nextInt(1, 999999);
                users.add(new User(name, code, ra));
            }
            br.close();

            userRepository.saveAll(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
