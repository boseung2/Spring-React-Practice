import React, {useEffect} from 'react';
import {useDispatch, useSelector} from "react-redux";
import {changeField, initializeForm, register} from "../../modules/auth";
import SignUp from "../../components/common/SignUp";

const SignUpContainer = () => {
    const dispatch = useDispatch();
    const {form, auth, authError} = useSelector(({auth}) => ({
        form : auth.register,
        auth : auth.auth,
        authError : auth.authError
    }));

    // 인풋 변경 이벤트 핸들러
    const onChange = e => {
        const {value, name} = e.target;
        dispatch(
            changeField({
                form : 'register',
                key : name,
                value
            })
        );
    };

    // 폼 등록 이벤트 핸들러
    const onSubmit = e => {
        e.preventDefault();
        const {name, email, password, passwordConfirm} = form;
        if(password !== passwordConfirm) {
            // 오류처리해야함
            return;
        }
        dispatch(register({name, email, password}))
    }

    // 컴포넌트가 처음 렌더링될 때 form 을 초기화함
    useEffect(() => {
        dispatch(initializeForm('register'));
    }, [dispatch]);

    // 회원가입 성공/실패 처리
    useEffect(() => {
        if (authError) {
            console.log('오류 발생');
            console.log(authError);
            return;
        }
        if (auth) {
            console.log('회원가입 성공');
            console.log(auth);
        }
    }, [auth, authError]);

    return (
        <SignUp
            form={form}
            onChange={onChange}
            onSubmit={onSubmit}
        />
    );
};

export default SignUpContainer;