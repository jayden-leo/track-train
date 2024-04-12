import {defineStore} from 'pinia';
import {ref} from "vue";

const MEMBER = "MEMBER";
export const useMemberStore = defineStore('MemberStore', () => {
    let member = ref(window.SessionStorage.get(MEMBER)||{})
    const setMember = (memberData) => {
        member.value = memberData
        console.log(member.value)
        window.SessionStorage.set(MEMBER, memberData)

    }

    return {member, setMember }
})