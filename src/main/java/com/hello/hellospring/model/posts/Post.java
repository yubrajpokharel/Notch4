package com.hello.hellospring.model.posts;

import com.hello.hellospring.model.State;
import com.hello.hellospring.model.User;
import org.hibernate.validator.constraints.Range;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by yubraj on 4/17/16.
 */

@Entity
@Table(name = "POST")
public class Post {

    private static final int MIN_LEN = 10;
    private static final int MAX_LEN = 150;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "post")
    @Range(min = MIN_LEN, max = MAX_LEN)
    private String post;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date_posted;

    @NotNull
    @Column(name="state", nullable=false)
    private String state= State.ACTIVE.getState();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_modofied;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Date getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(Date date_posted) {
        this.date_posted = date_posted;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getPickupDateTime() {
        return date_modofied;
    }

    public void setPickupDateTime(Date pickupDateTime) {
        this.date_modofied = pickupDateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post1 = (Post) o;

        if (id != post1.id) return false;
        if (post != null ? !post.equals(post1.post) : post1.post != null) return false;
        if (date_posted != null ? !date_posted.equals(post1.date_posted) : post1.date_posted != null) return false;
        if (state != null ? !state.equals(post1.state) : post1.state != null) return false;
        return date_modofied != null ? date_modofied.equals(post1.date_modofied) : post1.date_modofied == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (date_posted != null ? date_posted.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (date_modofied != null ? date_modofied.hashCode() : 0);
        return result;
    }
}