package com.hello.hellospring.model.posts;

import com.hello.hellospring.model.State;
import com.hello.hellospring.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by yubraj on 4/17/16.
 */

@Entity
@Table(name = "post")
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "post", nullable = false)
    private String post;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private String date_posted;

    @NotNull
    @Column(name="STATE", nullable=false)
    private String state= State.ACTIVE.getState();

    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "post",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private User user = new User();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(String date_posted) {
        this.date_posted = date_posted;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(Date pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post1 = (Post) o;

        if (id != post1.id) return false;
        if (!post.equals(post1.post)) return false;
        if (!date_posted.equals(post1.date_posted)) return false;
        if (!state.equals(post1.state)) return false;
        if (!pickupDateTime.equals(post1.pickupDateTime)) return false;
        return user.equals(post1.user);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + post.hashCode();
        result = 31 * result + date_posted.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + pickupDateTime.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}