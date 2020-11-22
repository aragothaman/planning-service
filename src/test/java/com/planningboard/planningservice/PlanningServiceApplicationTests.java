package com.planningboard.planningservice;

import com.planningboard.planningservice.dataacess.Workspace;
import com.planningboard.planningservice.dataacess.repository.WorkspaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class PlanningServiceApplicationTests {
    @Autowired
    private WorkspaceRepository repository;

    @Test
    public void sampleTestCase() {
        Workspace wspace = new Workspace();
        wspace.setWorkspaceId("4000");
        wspace.setName("Hello4");
        this.repository.save(wspace);

        Iterable<Workspace> workspaces = this.repository.findAll();
        for (Workspace space:workspaces) {
            System.out.println(space);
        }

//        User hoeller = new User("Juergen", "Hoeller");
//        repository.save(hoeller);
//
//        List<User> result = repository.findByLastName("Gosling");
//        Assert.assertThat(result.size(), is(1));
//        Assert.assertThat(result, hasItem(gosling));
//        log.info("Found in table: {}", result.get(0));
    }

}




