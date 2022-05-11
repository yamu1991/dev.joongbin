package com.kakaopaysec.api.domain.user.domain;

// 유저 저장을 위한 클래스 인터페이스 -> 추후 DB가 바뀌거나 방법이 바뀌게 되어도 이 인터페이스를 구현하면 편리하게 바꿀 수 있음
public interface UserStore {

    User store(User initUser);
}
