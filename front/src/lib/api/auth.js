import client from "./client";

// 로그인
export const login = ({ email, password }) =>
    client.post('/api/login', {email, password});

// 회원가입
export const register = ({name, email, password}) =>
    client.post('/api/auth/register', {name, email, password});