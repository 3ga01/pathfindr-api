// package com.example.pathfindr.service.detailservice;

// import java.util.Collection;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.example.pathfindr.model.Mentor;
// import com.example.pathfindr.model.Role;
// import com.example.pathfindr.repository.MentorRepository;

// @Service
// public class MentorDetailService implements UserDetailsService{
//     @Autowired
//     private MentorRepository mentorRepository;

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//         Mentor mentor = mentorRepository.findByUsername(email);
//         if (mentor == null) {
//             throw new UsernameNotFoundException("User not found");
//         }
//         return new org.springframework.security.core.userdetails.User(mentor.getEmail(), mentor.getPassword(),
//                 mapRolesToAuthorities(mentor.getRoles()));

//     }

//     private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
//         return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//     }
// }
