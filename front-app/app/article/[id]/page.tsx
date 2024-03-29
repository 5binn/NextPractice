'use client'

import { useParams  } from "next/navigation";
import { useEffect, useState } from "react";

interface ArticleData {
    id: number;
    title: string;
    content: string;
    createdDate: string;
    modifieDDate: string;
}

interface ArticleResponse {
    resultCode: string;
    msg: string;
    data: {
        article: ArticleData;
    }
}

export default function Id() {
    const params = useParams();
    const [article, setArticle] = useState<ArticleData | null>(null);
    useEffect(() => {
        fetch("http://localhost:8090/api/v1/articles/" + params.id)
        .then(response => response.json())
        .then((result: ArticleResponse) => setArticle(result.data.article));
    },[]);

    const formatDate = (dateString: string): string => {
        const date = new Date(dateString);
        return date.toLocaleString(); // 현재 로케일에 맞는 형식으로 날짜를 반환
    };

    if (!article) {
        return <div>Loading...</div>; // 로딩 중 메시지 표시
    }

    return (
        <div>
            <h1>{article?.id}번 / TITLE : {article?.title}</h1>
            <span>{formatDate(article.createdDate)}</span>
            <div>
                {article?.content}
            </div>
        </div>
    );

}