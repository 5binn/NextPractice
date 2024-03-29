'use client'

import Link from "next/link";
import { useEffect, useState } from "react";
import {ArticleData, ApiResponse} from "./types"

interface ArticleListResponse extends ApiResponse<ArticleData[]>{};

export default function Article() {

    const [articleList, setArticleList] = useState<ArticleData[]>([]);
    useEffect(() => {
        fetch("http://localhost:8090/api/v1/articles")
        .then(response => response.json())
        .then((result: ArticleListResponse)=> setArticleList(result.data.articleList));
    }, []);
    console.log(articleList);

    if (!articleList) {
        return <div>Loading...</div>; // 로딩 중 메시지 표시
    }

    return (
        <div>
            {articleList.map(article => 
            <li key={article.id}>
            <Link href={"/article/"+article.id}> {article.title}</Link>
            <Link href={"/article/"+article.id}> {article.content}</Link>
            </li>)}
        </div>
    )
}


