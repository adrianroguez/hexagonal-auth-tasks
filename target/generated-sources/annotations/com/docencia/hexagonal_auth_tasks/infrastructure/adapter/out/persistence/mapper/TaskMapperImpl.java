package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.mapper;

import com.docencia.hexagonal_auth_tasks.domain.model.Role;
import com.docencia.hexagonal_auth_tasks.domain.model.Task;
import com.docencia.hexagonal_auth_tasks.domain.model.User;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.RoleEntity;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.TaskEntity;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.UserEntity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-19T02:22:06+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toDomain(TaskEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( entity.getId() );
        task.setTitle( entity.getTitle() );
        task.setDescription( entity.getDescription() );
        task.setStartDate( entity.getStartDate() );
        task.setEndDate( entity.getEndDate() );
        task.setCompleted( entity.getCompleted() );
        task.setUser( userEntityToUser( entity.getUser() ) );

        return task;
    }

    @Override
    public TaskEntity toEntity(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId( task.getId() );
        taskEntity.setTitle( task.getTitle() );
        taskEntity.setDescription( task.getDescription() );
        taskEntity.setStartDate( task.getStartDate() );
        taskEntity.setEndDate( task.getEndDate() );
        taskEntity.setCompleted( task.getCompleted() );
        taskEntity.setUser( userToUserEntity( task.getUser() ) );

        return taskEntity;
    }

    protected List<Task> taskEntitySetToTaskList(Set<TaskEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Task> list = new ArrayList<Task>( set.size() );
        for ( TaskEntity taskEntity : set ) {
            list.add( toDomain( taskEntity ) );
        }

        return list;
    }

    protected Role roleEntityToRole(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleEntity.getId() );
        role.setName( roleEntity.getName() );

        return role;
    }

    protected List<Role> roleEntitySetToRoleList(Set<RoleEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( set.size() );
        for ( RoleEntity roleEntity : set ) {
            list.add( roleEntityToRole( roleEntity ) );
        }

        return list;
    }

    protected User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setUsername( userEntity.getUsername() );
        user.setPassword( userEntity.getPassword() );
        user.setTasks( taskEntitySetToTaskList( userEntity.getTasks() ) );
        user.setRoles( roleEntitySetToRoleList( userEntity.getRoles() ) );

        return user;
    }

    protected Set<TaskEntity> taskListToTaskEntitySet(List<Task> list) {
        if ( list == null ) {
            return null;
        }

        Set<TaskEntity> set = new LinkedHashSet<TaskEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( Task task : list ) {
            set.add( toEntity( task ) );
        }

        return set;
    }

    protected RoleEntity roleToRoleEntity(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( role.getId() );
        roleEntity.setName( role.getName() );

        return roleEntity;
    }

    protected Set<RoleEntity> roleListToRoleEntitySet(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        Set<RoleEntity> set = new LinkedHashSet<RoleEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( Role role : list ) {
            set.add( roleToRoleEntity( role ) );
        }

        return set;
    }

    protected UserEntity userToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setUsername( user.getUsername() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setTasks( taskListToTaskEntitySet( user.getTasks() ) );
        userEntity.setRoles( roleListToRoleEntitySet( user.getRoles() ) );

        return userEntity;
    }
}
