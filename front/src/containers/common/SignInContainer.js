import React, {useEffect} from 'react';
import {useDispatch, useSelector} from "react-redux";
import {changeField, initializeForm} from "../../modules/auth";
import SignIn from "../../components/common/SignIn";

const SignInContainer = () => {
    const dispatch = useDispatch();
    const {form} = useSelector(({auth}) => ({
        form: auth.login
    }));

    // 인풋 변경 이벤트 핸들러
    const onChange = e => {
        const {value, name} = e.target;
        dispatch(
            changeField({
                form: 'login',
                key: name,
                value
            })
        )
    }

    // 폼 등록 이벤트 핸들러
    const onSubmit = e => {
        e.preventDefault();
    }

    // 컴포넌트가 처음 렌더링될 때 form 을 초기화함
    useEffect(() => {
        dispatch(initializeForm('login'));
    }, [dispatch])

    return (
        <>
            <SignIn
                form={form}
                onChange={onChange}
                onSubmit={onSubmit}
            />
        </>
    )
}

export default SignInContainer;
