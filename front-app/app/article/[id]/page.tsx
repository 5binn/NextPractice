import { useRouter } from 'next/router';

export default function Id({ id }: { id: number }) {
    if (id === undefined) {
        return <div>값이 존재하지 않습니다.</div>;
    }

    return (
        <div>
            {id} 입니다.
        </div>
    );

}